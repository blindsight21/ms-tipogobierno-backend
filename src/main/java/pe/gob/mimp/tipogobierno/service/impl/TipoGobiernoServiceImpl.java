/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.tipogobierno.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mimp.siscap.model.TipoGobierno;
import pe.gob.mimp.siscap.repository.tipogobierno.TipoGobiernoRepository;
import pe.gob.mimp.tipogobierno.bean.FindByParamBean;
import pe.gob.mimp.tipogobierno.bean.TipoGobiernoBean;
import pe.gob.mimp.tipogobierno.converter.TipoGobiernoCast;
import pe.gob.mimp.tipogobierno.service.TipoGobiernoService;
import pe.gob.mimp.tipogobierno.util.Util;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class TipoGobiernoServiceImpl implements TipoGobiernoService {

    @Autowired
    private TipoGobiernoRepository tipoGobiernoRepository;

    @Override
    public void crearTipoGobierno(TipoGobiernoBean tipoGobiernoBean) throws Exception {

        TipoGobierno tipoGobierno = new TipoGobierno();
        tipoGobierno.setTxtTipoGobierno(tipoGobiernoBean.getTxtTipoGobierno());
        tipoGobierno.setNidUsuario(tipoGobiernoBean.getNidUsuario());
        tipoGobierno.setTxtPc(tipoGobiernoBean.getTxtPc());
        tipoGobierno.setTxtIp(tipoGobiernoBean.getTxtIp());
        tipoGobierno.setFecEdicion(tipoGobiernoBean.getFecEdicion());
        tipoGobierno.setFlgActivo(tipoGobiernoBean.getFlgActivo());

        tipoGobiernoRepository.save(tipoGobierno);

    }

    @Override
    public void editarTipoGobierno(TipoGobiernoBean tipoGobiernoBean) {

        TipoGobierno tipoGobierno = new TipoGobierno();

        tipoGobierno.setNidTipoGobierno(tipoGobiernoBean.getNidTipoGobierno());
        tipoGobierno.setTxtTipoGobierno(tipoGobiernoBean.getTxtTipoGobierno());
        tipoGobierno.setNidUsuario(tipoGobiernoBean.getNidUsuario());
        tipoGobierno.setTxtPc(tipoGobiernoBean.getTxtPc());
        tipoGobierno.setTxtIp(tipoGobiernoBean.getTxtIp());
        tipoGobierno.setFecEdicion(tipoGobiernoBean.getFecEdicion());
        tipoGobierno.setFlgActivo(tipoGobiernoBean.getFlgActivo());

        tipoGobiernoRepository.save(tipoGobierno);

    }

    @Override
    public String obtenerTipoGobiernoPorId(BigDecimal nidTipoGobierno) throws Exception {

        Optional<TipoGobierno> tipoGobierno = tipoGobiernoRepository.findById(nidTipoGobierno);

        if (tipoGobierno.isPresent()) {
            return tipoGobierno.get().getTxtTipoGobierno();
        }

        return "";
    }

    @Override
    public List<TipoGobiernoBean> loadTipoGobiernoList(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }

        List<TipoGobierno> tipoGobiernoList = tipoGobiernoRepository.findByParams(findByParamBean.getParameters(), findByParamBean.getOrderBy());

        if (!Util.esListaVacia(tipoGobiernoList)) {

            return tipoGobiernoList.stream().map(tipoGobierno -> {
                TipoGobiernoBean tipoGobiernoBean = new TipoGobiernoBean();
                tipoGobiernoBean.setNidTipoGobierno(tipoGobierno.getNidTipoGobierno());
                tipoGobiernoBean.setTxtTipoGobierno(tipoGobierno.getTxtTipoGobierno());
                tipoGobiernoBean.setNidUsuario(tipoGobierno.getNidUsuario());
                tipoGobiernoBean.setTxtPc(tipoGobierno.getTxtPc());
                tipoGobiernoBean.setTxtIp(tipoGobierno.getTxtIp());
                tipoGobiernoBean.setFecEdicion(tipoGobierno.getFecEdicion());
                tipoGobiernoBean.setFlgActivo(tipoGobierno.getFlgActivo());
                return tipoGobiernoBean;
            }).collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public Integer getRecordCount(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }
        Integer count = tipoGobiernoRepository.getRecordCount(findByParamBean.getParameters());
        return count;
    }

    @Override
    public TipoGobiernoBean find(BigDecimal id) {

        Optional<TipoGobierno> gobierno = tipoGobiernoRepository.findById(id);

        if (!gobierno.isPresent()) {
            return null;
        }

        return TipoGobiernoCast.castTipoGobiernoToTipoGobiernoBean(gobierno.get());

    }

}
