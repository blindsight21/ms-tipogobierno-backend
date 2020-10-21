/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.tipogobierno.service;

import java.math.BigDecimal;
import java.util.List;
import pe.gob.mimp.tipogobierno.bean.FindByParamBean;
import pe.gob.mimp.tipogobierno.bean.TipoGobiernoBean;

/**
 *
 * @author Omar
 */
public interface TipoGobiernoService {

    void crearTipoGobierno(TipoGobiernoBean tipoGobiernoBean) throws Exception;

    void editarTipoGobierno(TipoGobiernoBean tipoGobiernoBean) throws Exception;

//    void anularTipoGobierno(TipoGobiernoBean tipoGobiernoBean) throws Exception;
    String obtenerTipoGobiernoPorId(BigDecimal nidTipoGobierno) throws Exception;

    List<TipoGobiernoBean> loadTipoGobiernoList(FindByParamBean findByParamBean) throws Exception;

    Integer getRecordCount(FindByParamBean findByParamBean) throws Exception;

    TipoGobiernoBean find(BigDecimal id);
}
