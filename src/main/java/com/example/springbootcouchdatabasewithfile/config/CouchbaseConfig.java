package com.example.springbootcouchdatabasewithfile.config;

import com.example.springbootcouchdatabasewithfile.model.FileInfo;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.couchbase.CouchbaseClientFactory;
import org.springframework.data.couchbase.SimpleCouchbaseClientFactory;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.data.couchbase.core.convert.CouchbaseCustomConversions;
import org.springframework.data.couchbase.repository.config.RepositoryOperationsMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Collections;

@Configuration
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Autowired
    private ApplicationContext context;

    @Override
    public String getConnectionString() {
        return "couchbase://localhost";
    }

    @Override
    public String getUserName() {
        return "root";
    }

    @Override
    public String getPassword() {
        return "password";
    }

    @Override
    public String getBucketName() {
        return "fileList";
    }

    @Override
    public void configureRepositoryOperationsMapping(RepositoryOperationsMapping mapping) {
        mapping.mapEntity(FileInfo.class, getCouchbaseTemplate(getBucketName()));
    }

    @SneakyThrows
    private CouchbaseTemplate getCouchbaseTemplate(String bucketName) {
        CouchbaseTemplate template = new CouchbaseTemplate(couchbaseClientFactory(bucketName),
                mappingCouchbaseConverter(couchbaseMappingContext(customConversions()),
                        new CouchbaseCustomConversions(Collections.emptyList())));

        template.setApplicationContext(context);
        return template;
    }

    private CouchbaseClientFactory couchbaseClientFactory(String bucketName) {
        return new SimpleCouchbaseClientFactory(couchbaseCluster(couchbaseClusterEnvironment()),
                bucketName, this.getScopeName());
    }

}
