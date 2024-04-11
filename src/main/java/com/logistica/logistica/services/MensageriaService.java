package com.logistica.logistica.services;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor
@Service
@Getter
public class MensageriaService<T> {
    private String mensagemCliente;
    private String mensagemServidor;
    private T data;
    private Integer status;
    private List<T> datas;

    public MensageriaService(String mensagemCliente, String mensagemServidor, T data, Integer status) {
        this.mensagemCliente = mensagemCliente;
        this.mensagemServidor = mensagemServidor;
        this.data = data;
        this.status = status;
    }

    public MensageriaService(String mensagemCliente, T data, Integer status) {
        this.mensagemCliente = mensagemCliente;
        this.data = data;
        this.status = status;
    }

    public MensageriaService(String mensagemCliente, List<T> datas, int status) {
        this.mensagemCliente = mensagemCliente;
        this.datas = datas;
        this.status = status;
    }

    public MensageriaService(String mensagemCliente, T data) {
        this.mensagemCliente = mensagemCliente;
        this.data = data;
    }

    public MensageriaService(String mensagemCliente, int status) {
        this.mensagemCliente = mensagemCliente;
        this.status = status;
    }

    public MensageriaService(String mensagemCliente, String mensagemServidor, Integer status) {
        this.mensagemCliente = mensagemCliente;
        this.mensagemServidor = mensagemServidor;
        this.status = status;
    }

    public MensageriaService(T data, Integer status){
        this.data = data;
        this.status = status;
    }
}
