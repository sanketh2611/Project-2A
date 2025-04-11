package com.example;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HelloWorldServletTest {


    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @InjectMocks
    private HelloWorldServlet servlet;

    @Test
    public void testDoGet() throws ServletException, IOException {
        // Create a string writer to capture the output
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        // Set up the mock response to use the string writer
        when(response.getWriter()).thenReturn(printWriter);

        // Call the doGet method
        servlet.doGet(request, response);

        // Verify the output
        assertEquals("Hello, World!\n", stringWriter.toString());
    }
}

