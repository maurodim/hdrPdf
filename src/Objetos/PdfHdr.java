/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;



import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;

import com.lowagie.text.pdf.draw.LineSeparator;
import java.awt.Color;


import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author mauro di
 */
public class PdfHdr extends Thread{
    private ArrayList lstPedidos;
    private Connection cn;
    private Integer idListado;
    private String listadoNumero;
    private String revision;
    private String titulo;
    private String vehiculo;
    private String pesoTotal;
    private String nombreCliente;
    private String codigoCliente;
    private String numeroVendedor;
    private String empresa;
    private String comprobante;
    private String monto;
    private String vuelto;
    private String observaciones;
    private Double totalMonto;
    private Double totalVuelto;
    private String rutaDestino;
    private String operador;
    private String celularOperador;
    private String destinoRemoto;

    public String getDestinoRemoto() {
        return destinoRemoto;
    }

    public void setDestinoRemoto(String destinoRemoto) {
        this.destinoRemoto = destinoRemoto;
    }
    

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getCelularOperador() {
        return celularOperador;
    }

    public void setCelularOperador(String celularOperador) {
        this.celularOperador = celularOperador;
    }
    

    public String getRutaDestino() {
        return rutaDestino;
    }

    public void setRutaDestino(String rutaDestino) {
        this.rutaDestino = rutaDestino;
    }
    

    public Integer getIdListado() {
        return idListado;
    }

    public void setIdListado(Integer idListado) {
        this.idListado = idListado;
    }

    
    public String getListadoNumero() {
        return listadoNumero;
    }

    public void setListadoNumero(String listadoNumero) {
        this.listadoNumero = listadoNumero;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(String pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNumeroVendedor() {
        return numeroVendedor;
    }

    public void setNumeroVendedor(String numeroVendedor) {
        this.numeroVendedor = numeroVendedor;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getVuelto() {
        return vuelto;
    }

    public void setVuelto(String vuelto) {
        this.vuelto = vuelto;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Double getTotalMonto() {
        return totalMonto;
    }

    public void setTotalMonto(Double totalMonto) {
        this.totalMonto = totalMonto;
    }

    public Double getTotalVuelto() {
        return totalVuelto;
    }

    public void setTotalVuelto(Double totalVuelto) {
        this.totalVuelto = totalVuelto;
    }
    
    

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    

    public ArrayList getLstPedidos() {
        return lstPedidos;
    }

    public void setLstPedidos(ArrayList lstPedidos) {
        this.lstPedidos = lstPedidos;
    }


    public PdfHdr(Connection cn, Integer idListado,String rutaDestino,String destinoRemoto) {
        this.cn = cn;
        this.idListado=idListado;
        this.rutaDestino=rutaDestino;
        this.destinoRemoto=destinoRemoto;
    }

    public PdfHdr() {
   
    
    }

    

    
    
    

    
    
    @Override
    public void run(){
        
        Document documento=new Document();
        int i=1;
        //String clienteF=doc.getAfipPlastCbte().replace(":","_");
        String arch=this.getRutaDestino();
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        File fich=new File(arch);
        while(fich.exists()){
            i++;
            //int rev=this.idRevision++;
            arch="c:\\Hdr\\"+this.idListado+"hdr.pdf";
            fich=new File(arch);
        }
        FileOutputStream fichero;
        try {
            
            
            fichero=new FileOutputStream(arch);
            PdfWriter writer=PdfWriter.getInstance(documento, fichero);
            documento.open();
            PdfContentByte cb=writer.getDirectContent();
            /*
            if(Propiedades.getLOGO() != ""){
                Image imagen= Image.getInstance(Propiedades.getLOGO());
                imagen.scaleAbsolute(190, 110);
                documento.add(imagen);
            }
            */
            System.out.println(this.cn.toString());
            String sql1=null;
            //String reem='replace(left(hdr.fechaEntrega,6),'"+"/","")as fechaTit";
            String sql="select hdr.listadoNumero,(select listadosdemateriales.revision from listadosdemateriales where listadosdemateriales.numero=hdr.listadoNumero)as rev,(select unidades.descripcion from unidades where numero=hdr.numeroVehiculo)as descripcionUnidad,(select unidades.descripcion from unidades where numero=hdr.numeroVehiculo)as descV,round(hdr.pesoCarga,2) as pesoTot,(select unidades.kilometrosActuales from unidades where numero=hdr.numeroVehiculo)as unidadKm,(select fleteros.nombre from fleteros where numero=hdr.numeroFletero)as nombreFletero,(select fleteros.celular from fleteros where numero=hdr.numeroFletero)as celularFletero,left(hdr.fechaEntrega,5)as fechaTit,left((select unidades.descripcion from unidades where numero=hdr.numeroVehiculo),5)as nombreV,substring((select unidades.descripcion from unidades where numero=hdr.numeroVehiculo),6)as turnoV from hdr where numero="+this.getIdListado();
            Statement st=this.cn.createStatement();
            Statement st1=this.cn.createStatement();
            ResultSet rs1 = null;
            ResultSet rs=st.executeQuery(sql);
            
            LineSeparator linea=new LineSeparator();
            Rectangle recta = null;
            BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA_BOLD,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
            cb.setFontAndSize(bf,12);
            cb.beginText();
            String unidadKm=null;
            String titF="";
            String titF1="";
            String titF2="";
            String turno="";
            String vehi="";
            String vw="";
            int largo=0;
            while(rs.next()){
                
                titF1=rs.getString("fechaTit");
                titF=titF1.substring(0,2);
                titF2=titF1.substring(3);
                titF=titF+titF2;
                vehi=rs.getString("nombreV");
                largo=vehi.length();
                //largo=largo - 1;
                
                turno=rs.getString("turnoV");
                turno=turno.trim();
                if(turno.equals(""))turno="1";
                vw=vehi.substring(0,2);
                vw.trim();
                if(vw.equals("VW")){
                    vehi=vw;
                }else{
                    vehi=vehi.substring(0, largo);
                }
                this.setTitulo(vehi+" "+titF+" - "+turno);
                this.setVehiculo(rs.getString("descripcionUnidad"));
                this.setListadoNumero("LPM Nº: "+rs.getString("listadoNumero")+" Rev: "+rs.getString("rev"));
                this.setPesoTotal("Total Kg.: "+rs.getString("pesoTot"));
                this.setOperador(rs.getString("nombrefletero"));
                this.setCelularOperador("Cel.: "+rs.getString("celularFletero"));
                unidadKm=rs.getString("unidadKm");
                
            }
            rs.close();
            linea.setLineWidth(2);
            linea.drawLine(cb,40,550,830);
            cb.setTextMatrix(230,815);
            cb.showText(this.getTitulo());
            linea.setLineWidth(1);
            linea.drawLine(cb,40,550,810);
            //cb.showText("eR&Re");
            //cb.add(imagen);
            cb.setFontAndSize(bf,8);
            cb.setTextMatrix(40, 800);
            cb.showText(this.getVehiculo());
            cb.setTextMatrix(40,790);
            cb.showText(this.getListadoNumero());
            cb.setTextMatrix(40,780);
            cb.showText(this.getPesoTotal());
            //cb.showText("PAPELES");
            bf = BaseFont.createFont(BaseFont.COURIER,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
            cb.setFontAndSize(bf,8);
            cb.setTextMatrix(370,800);
            cb.showText("Fecha y Hora: "+hourdateFormat.format(date));
             bf = BaseFont.createFont(BaseFont.COURIER_BOLD,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
            cb.setFontAndSize(bf,10);
            cb.setTextMatrix(370,790);
            cb.showText(this.getOperador());
            cb.setTextMatrix(370,780);
            cb.showText(this.getCelularOperador());
            
            linea.setLineWidth(1);
            linea.drawLine(cb,40,550,770);
            
            bf = BaseFont.createFont(BaseFont.COURIER,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
            cb.setFontAndSize(bf,7);
            cb.setTextMatrix(40,760);
            cb.showText("Kilometros Salida: "+unidadKm);
            cb.setTextMatrix(40,745);
            cb.showText("Kilometros Llegada: __________________");
            cb.setTextMatrix(230,760);
            cb.showText("Reviso:_______________");
            cb.setTextMatrix(330,760);
            cb.showText("H. Salida:______________");
            cb.setTextMatrix(450,760);
            cb.showText("Auxiliar:_________________");
            cb.setTextMatrix(230,745);
            cb.showText("Recibio:______________");
            cb.setTextMatrix(330,745);
            cb.showText("H.Llegada:______________");
            
            linea.setLineWidth(1);
            linea.drawLine(cb,40,550,740);
            
            
            //cb.showText("de Rivadeneira Enrique y Rivadeneira Jorge S.H.");
            bf = BaseFont.createFont(BaseFont.COURIER_BOLD,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
            int renglon;
            cb.setFontAndSize(bf,8);
            cb.setTextMatrix(50,730);
            cb.showText("|Vend");
            cb.setTextMatrix(90,730);
            cb.showText("|Cod. Cliente");
            cb.setTextMatrix(160,730);
            cb.showText("");
            cb.setTextMatrix(320,730);
            cb.showText("|Rto");
            cb.setTextMatrix(500, 730);
            cb.showText("|Vto");
            //cb.setTextMatrix(500,730);
            //cb.showText("|Observaciones");
            linea.setLineWidth(1);
            linea.setLineColor(Color.GRAY);
            linea.drawLine(cb, 40, 550, 725);
            
            renglon=715;
            
            
            //ACA COMIENZA EL BUCLE DE ENCABEZADO DE PEDIDOS
            sql1="select detalle_hdr.cliente,detalle_hdr.vendedor,detalle_hdr.orden as contador,detalle_hdr.numero_cli,detalle_hdr.observaciones,detalle_hdr.comprobante,detalle_hdr.importe,detalle_hdr.vuelto,detalle_hdr.empresa,(select round(hdr.totalMonto,2) from hdr where hdr.numero="+this.getIdListado()+")as totalMonto,(select round(hdr.totalVuelto,2) from hdr where hdr.numero="+this.getIdListado()+" ) as totalVuelto from detalle_hdr where hdr="+this.getIdListado()+" group by cliente,numero_cli order by orden";
            rs1=st1.executeQuery(sql1);
            PdfHdr pdf;
            //Iterator it=this.getLstPedidos().listIterator();
            int contador=0;
            Double impo=0.00;
            String importe=null;
            String comprobante=null;
            String nombreCliente="";
            while(rs1.next()){
                //pdf=(PdfListado) it.next();
                contador++;
                bf = BaseFont.createFont(BaseFont.COURIER,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                cb.setFontAndSize(bf,7);
                cb.setTextMatrix(40,renglon);
                cb.showText(String.valueOf(contador));
                cb.setTextMatrix(50,renglon);
                cb.showText(rs1.getString("vendedor"));
                cb.setTextMatrix(90,renglon);
                
                cb.showText(rs1.getString("numero_cli"));
                //bf = BaseFont.createFont(BaseFont.COURIER,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                //cb.setFontAndSize(bf,6);
                cb.setTextMatrix(130,renglon);
                nombreCliente=rs1.getString("cliente");
                if(nombreCliente.length() > 38)nombreCliente=nombreCliente.substring(0,38);
                cb.showText(nombreCliente);
                //bf = BaseFont.createFont(BaseFont.COURIER_BOLD,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                //cb.setFontAndSize(bf,8);
                cb.setTextMatrix(300,renglon);
                cb.showText(rs1.getString("empresa"));
                cb.setTextMatrix(320,renglon);
                comprobante=rs1.getString("comprobante");
                if(comprobante.length() > 14){
                   String compro;
                   String compro2 = null;
                   int bbc=0;
                   for(int abc=14;abc < comprobante.length(); abc=abc + 14){
                       bbc= abc - 5;
                       compro=comprobante.substring(bbc,abc);
                       if(abc > 14 ){
                           compro="/"+compro;
                       }
                       compro2=compro2 + compro.trim();
                   }
                   comprobante=compro2;
                }
                cb.showText(comprobante);
                cb.setTextMatrix(460,renglon);
                impo=0.00;
                //impo=rs.getDouble("importe");
                importe=rs1.getString("importe");
                if(importe !=null){
                    //this.totalMonto=this.totalMonto + rs1.getDouble("importe");
                    //importe=String.valueOf(impo);
                    //if(impo==0)importe="PS";
                }else{
                    importe="PS";
                }
                cb.showText(importe);
                String vuelto=rs1.getString("vuelto");
                if(vuelto != null ){
                    if(vuelto.equals("null"))vuelto="0.00";
                    //this.totalVuelto=this.totalVuelto + vuelto;
                }else{
                    vuelto="0.00";
                }
                cb.setTextMatrix(500,renglon);
                cb.showText(vuelto);
                //cb.setTextMatrix(500,renglon);
                //cb.showText(rs1.getString("observaciones"));
                

                renglon=renglon - 10;
                this.totalMonto=rs1.getDouble("totalMonto");
                this.totalVuelto=rs1.getDouble("totalVuelto");
                    
                }
                //rs.close();
                rs1.close();
                bf = BaseFont.createFont(BaseFont.COURIER_BOLD,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                cb.setFontAndSize(bf,7);
                cb.setTextMatrix(460,renglon);
                cb.showText("TOTAL");
                cb.setTextMatrix(500,renglon);
                cb.showText("VTOS");
                renglon=renglon -10;
                cb.setTextMatrix(460,renglon);
                String totall=String.valueOf(this.totalMonto);
                
                cb.showText(totall);
                cb.setTextMatrix(500,renglon);
                cb.showText(String.valueOf(this.totalVuelto));
                
            
            
            //pie de documento
            //renglon=50;
            renglon=renglon - 20;
            cb.setFontAndSize(bf,8);
            cb.setTextMatrix(40,renglon);
            cb.showText("GASTOS:____________________________");
            
            renglon=renglon - 10;
            cb.setTextMatrix(40,renglon);
            cb.showText("RINDIO:____________________________");
            cb.setTextMatrix(500,renglon);
            cb.showText(String.valueOf(this.idListado));
            
            
            
            
            
            cb.endText();
            documento.close();
            
            File f=new File(arch);
            //File f2=new File(this.destinoRemoto);
            if(f.exists()){
            
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+arch);
                File remoto=new File(this.getDestinoRemoto());
                InputStream in=new FileInputStream(arch);
                OutputStream out=new FileOutputStream(remoto);
                byte[] buf = new byte[1024];
                int len;

                while ((len = in.read(buf)) > 0) {
                  out.write(buf, 0, len);
                }
                in.close();
                out.close();
            }
            int confirmacion=0;
            
            
            /*
            if(doc.getArchivo().isEmpty()){
                
            }else{
                confirmacion=JOptionPane.showConfirmDialog(null, "DESEA NOTIFICAR POR MAIL?");
            if(confirmacion==0){
                //JOptionPane.showMessageDialog(null,"acepto");
                
            }
            }
                    */
            System.out.println("eligio "+confirmacion);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PdfHdr.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
            
        } catch (DocumentException ex) {
            Logger.getLogger(PdfHdr.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
        } catch (IOException ex) {
            Logger.getLogger(PdfHdr.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
        } catch (SQLException ex) {
            Logger.getLogger(PdfHdr.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
        }
        
        
    }
    
}
