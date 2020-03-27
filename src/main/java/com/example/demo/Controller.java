package com.example.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller
{
    @GetMapping( "/custom-logout" )
    public void foo( final HttpServletRequest request ) throws ServletException
    {
        System.out.println( SecurityContextHolder.getContext().getAuthentication() );

        request.logout();

        System.out.println( SecurityContextHolder.getContext().getAuthentication() );
    }
}
