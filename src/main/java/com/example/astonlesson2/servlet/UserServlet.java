package com.example.astonlesson2.servlet;

import com.example.astonlesson2.dto.UserDto;

import com.example.astonlesson2.service.ServiceUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    ServiceUser serviceUser;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException { //этот спрособ тже не работает
       response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        if (request.getParameter("id") == null) {
            List<UserDto> userAll = serviceUser.getAll();
            List<String> getAll = new ArrayList<>();
            userAll.forEach(s -> {
                try {
                    String out = new ObjectMapper().writeValueAsString(s);
                    getAll.add(out);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            });
            response.getWriter().write(String.valueOf(getAll));

        } else {
            int id = Integer.parseInt(request.getParameter("id"));
            UserDto userDto = serviceUser.findById(id);
            String json = new ObjectMapper().writeValueAsString(userDto);
            response.getWriter().write(json);
        }
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
     serviceUser.create(userForJ(request));
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        serviceUser.update(userForJ(request));
        response.setStatus(200);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        serviceUser.deleteById(id);
        response.setStatus(200);
    }
    private UserDto userForJ (HttpServletRequest req) {
        try {
            InputStream inputStream = req.getInputStream();
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            return new ObjectMapper().readValue(builder.toString(), UserDto.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}




