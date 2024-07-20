package com.example.astonlesson2.servlet;

import com.example.astonlesson2.dto.AddressDto;
import com.example.astonlesson2.repository.dao.JDBCInit;
import com.example.astonlesson2.service.ServiceAddress;;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.*;
import lombok.AllArgsConstructor;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@AllArgsConstructor
@WebServlet(urlPatterns = "/address")
public class AddressServlet extends HttpServlet { //не работают сервлеты, чего-то не хватает не понимаю чего)
    private ServiceAddress serviceAddress ;


    @Override
    public void init() throws ServletException { //не создаются таблицы
        JDBCInit jdbcInit = new JDBCInit();
        jdbcInit.initializeDatabase();

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("doGet");
        String id = request.getParameter("id");
        if (id != null && !id.isEmpty()) {
            AddressDto addressDto = serviceAddress.findById(Integer.parseInt(id));
            PrintWriter printWriter = response.getWriter();
            printWriter.write(addressDto.toString());
            printWriter.close();
        } else {
            List<AddressDto> addressDto = serviceAddress.getAll();
            PrintWriter printWriter = response.getWriter();
            for (AddressDto addressDto1 : addressDto) {
                printWriter.write(addressDto1.toString() + "\n");
            }
            printWriter.close();
        }
        response.setStatus(200);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        AddressDto addressDto = new AddressDto();
        addressDto.setCityDto(request.getParameter("city"));
        addressDto.setStreetDti(request.getParameter("street"));
        addressDto.setHouseNumberDto(request.getParameter("houseNumber"));
        addressDto.setIdDto(Integer.parseInt(request.getParameter("address_id")));
        serviceAddress.create(addressDto);
        response.setStatus(200);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        AddressDto addressDto = serviceAddress.findById(id);
        if (request.getParameter("city,houseNumber,street") != null) {
            addressDto.setCityDto(request.getParameter("city"));
            addressDto.setStreetDti(request.getParameter("street"));
            addressDto.setHouseNumberDto(request.getParameter("houseNumber"));
        } else if (request.getParameter("address_id") != null) {
            addressDto.setIdDto(Integer.parseInt(request.getParameter("address_id")));
        }
        serviceAddress.update(addressDto);
        response.setStatus(200);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        serviceAddress.deleteById(id);
        resp.setStatus(200);
    }
}


