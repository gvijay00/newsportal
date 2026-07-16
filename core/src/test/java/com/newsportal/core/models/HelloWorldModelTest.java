package com.newsportal.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import com.newsportal.core.testcontext.AppAemContext;

@ExtendWith(AemContextExtension.class)
class HelloWorldModelTest {

    private final AemContext context = AppAemContext.newAemContext();

    private HelloWorldModel hello;

    @BeforeEach
    void setup() {

        Resource resource = context.create().resource(
            "/content/mypage/hello",
            "sling:resourceType", "newsportal/components/helloworld",
            "text", "Welcome to News Portal",
            "description", "Latest News"
        );

        hello = resource.adaptTo(HelloWorldModel.class);
    }

    @Test
    void testModel() {
        assertEquals("Welcome to News Portal", hello.getText());
        assertEquals("Latest News", hello.getDescription());
    }
}