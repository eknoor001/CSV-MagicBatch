package com.demo.config;

import java.io.File;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.demo.model.Loan;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private Resource inputFileResource;
    
    @Autowired
    private File outputFile;

    @Bean
    public FlatFileItemReader<Loan> itemReader() {
        FlatFileItemReader<Loan> reader = new FlatFileItemReader<>();
        reader.setResource(inputFileResource);
        reader.setLineMapper(new DefaultLineMapper<Loan>() {
            {
                setLineTokenizer(new DelimitedLineTokenizer() {
                    {
                    	setNames(new String[] { "loan_id", "status", "principal", "terms", "effective_date", "due_date",
                                "paid_off_time", "past_due_days", "age", "education", "gender" });
                       
                    }
                });
                reader.setLinesToSkip(1);
                setFieldSetMapper(new BeanWrapperFieldSetMapper<Loan>() {
                    {
                        setTargetType(Loan.class);
                    }
                });
            }
        });
        return reader;
    }



    @Bean
    public ItemWriter<Loan> itemWriter() {
        FlatFileItemWriter<Loan> writer = new FlatFileItemWriter<>();
        writer.setResource(new FileSystemResource(outputFile));
        writer.setLineAggregator(new DelimitedLineAggregator<Loan>() {
            {
                setDelimiter(",");
                setFieldExtractor(new BeanWrapperFieldExtractor<Loan>() {
                    {
                        setNames(new String[]{"loan_id", "status", "principal", "terms", "effective_date", "due_date",
                                "paid_off_time", "past_due_days", "age", "education", "gender"});
                    }
                });
            }
        });
        return writer;
    }

    
    @Bean
    public Step step() {
        return stepBuilderFactory.get("step")
                .<Loan, Loan>chunk(10)
                .reader(itemReader())
                .writer(itemWriter())
                .build();
    }

    @Bean
    public Job job(Step step) {
        return jobBuilderFactory.get("job")
                .start(step)
                .build();
    }
}

