/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.tipogobierno.ws.rest;

import java.math.BigDecimal;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.mimp.tipogobierno.bean.FindByParamBean;

import pe.gob.mimp.tipogobierno.bean.ResponseData;
import pe.gob.mimp.tipogobierno.bean.TipoGobiernoBean;
import pe.gob.mimp.tipogobierno.service.TipoGobiernoService;

/**
 *
 * @author BlindSight
 */
@RestController
@RequestMapping(value = "/")
public class TipoGobiernoController {

    @Autowired
    private TipoGobiernoService tipoGobiernoService;

    @PostMapping(value = "/crearTipoGobierno", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> crearTipoGobierno(@RequestBody TipoGobiernoBean tipoGobiernoBean) throws Exception {

        tipoGobiernoService.crearTipoGobierno(tipoGobiernoBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.CREATED.value());
        response.setMsg(HttpStatus.CREATED.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/editarTipoGobierno", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> editarTipoGobierno(@RequestBody TipoGobiernoBean tipoGobiernoBean) throws Exception {

        tipoGobiernoService.editarTipoGobierno(tipoGobiernoBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/obtenerTipoGobiernoPorId/{nidTipoGobierno}")
    public ResponseEntity<ResponseData<?>> obtenerTipoGobiernoPorId(@PathVariable("nidTipoGobierno") BigDecimal nidTipoGobierno) throws Exception {

        String txtTipoGobierno = tipoGobiernoService.obtenerTipoGobiernoPorId(nidTipoGobierno);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(txtTipoGobierno);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/loadTipoGobiernoList", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> loadTipoGobiernoList(@RequestBody FindByParamBean findByParamBean) throws Exception {

        List<TipoGobiernoBean> tipoGobiernoList = tipoGobiernoService.loadTipoGobiernoList(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(tipoGobiernoList);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/getRecordCount", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> getRecordCount(@RequestBody FindByParamBean findByParamBean) throws Exception {

        Integer count = tipoGobiernoService.getRecordCount(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(count);

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<ResponseData<?>> find(@PathVariable("id") BigDecimal id) throws Exception {

        TipoGobiernoBean tipoGobiernoBean = tipoGobiernoService.find(id);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(tipoGobiernoBean);

        return ResponseEntity.ok(response);

    }

}
