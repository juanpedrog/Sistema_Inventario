
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juan Pedro Gil
 */
public class CrearPDF {
    public void generarPDF() throws FileNotFoundException, DocumentException{
        String path="C:\\Nueva carpeta\\prueba.pdf";
        try{
        File f=new File(path);
        f.delete();
        Document document=new Document(PageSize.A4,0f,0f,0f,0f);
        PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream(path));
        ArrayList<String> datos;
        Conexion conexion=new Conexion();
        conexion.conexion();
        document.open();
        /*Font fuenteTitulo=new Font();
        fuenteTitulo.setSize(16);
        fuenteTitulo.setStyle(Font.BOLD);
        Paragraph solicitud_Viaticos=new Paragraph("Solicitud de viáticos",fuenteTitulo);
        solicitud_Viaticos.setAlignment(Paragraph.ALIGN_CENTER);
        fuenteTitulo.isBold();
        document.add(solicitud_Viaticos);
        Conexion conexion=new Conexion();
        conexion.conexion();
        ArrayList<String> datos;
        datos=conexion.acceder("select fecha_salida from solicitud where idSolicitud=(select max(idSolicitud) from solicitud);");
        Font fontSubrayar=new Font();
        Font fontNegritas=new Font();
        fontNegritas.setStyle(Font.BOLD);
        fontSubrayar.setStyle(Font.UNDERLINE);
        Paragraph fecha_salida=new Paragraph("  Fecha de salida: ",fontNegritas);
        Paragraph query=new Paragraph(datos.get(0),fontSubrayar);
        Paragraph fecha2=new Paragraph("    Fecha de llegada: ",fontNegritas);
        datos=conexion.acceder("select fecha_llegada from solicitud where idSolicitud=(select max(idSolicitud) from solicitud);");
        query=new Paragraph(datos.get(0),fontSubrayar);
        fecha2.add(query);
        query.add(fecha2);
        fecha_salida.add(query);
        document.add(fecha_salida);*/
        BaseFont bf=BaseFont.createFont(BaseFont.COURIER_BOLD,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
        BaseFont bfNoNegritas=BaseFont.createFont(BaseFont.COURIER,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
        PdfContentByte cb=writer.getDirectContent();
        cb.setFontAndSize(bf,16);
        Image image=Image.getInstance(getClass().getResource("/Imagenes/icono.png"));
        document.add(image);
        cb.beginText();
        //Label solicitud de viáticos
        cb.setTextMatrix(250,800);
        cb.showText("Solicitud de viaticos");
        //Label fecha de salida
        cb.setFontAndSize(bfNoNegritas,12);
        cb.setTextMatrix(50,700);
        cb.showText("Fecha de salida: ");
        //Fecha de salida de la base de datos
        cb.setFontAndSize(bf,12);
        datos=conexion.acceder("select fecha_salida from solicitud where idSolicitud=(select max(idSolicitud) from solicitud);");
        cb.setTextMatrix(180,700);
        cb.showText(datos.get(0));
        //Label fecha de llegada
        cb.setTextMatrix(270,700);
        cb.setFontAndSize(bfNoNegritas,12);
        cb.showText("Fecha de llegada: ");
        //Fecha de llegada de la base de datos
        cb.setFontAndSize(bf,12);
        datos=conexion.acceder("select fecha_llegada from solicitud where idSolicitud=(select max(idSolicitud) from solicitud);");
        cb.setTextMatrix(400,700);
        cb.showText(datos.get(0));
        //Label nombre
        cb.setFontAndSize(bfNoNegritas,12);
        cb.setTextMatrix(50,650);
        cb.showText("Nombre: ");
        //Nombre base de datos
        cb.setFontAndSize(bf,12);
        datos=conexion.acceder("select nombre from solicitud where idSolicitud=(select max(idSolicitud) from solicitud);");
        cb.setTextMatrix(130,650);
        cb.showText(datos.get(0));
        //Label lugar
        cb.setFontAndSize(bfNoNegritas,12);
        cb.setTextMatrix(320,650);
        cb.showText("Lugar: ");
        //Lugar base de datos
        cb.setFontAndSize(bf,12);
        datos=conexion.acceder("select lugar from solicitud where idSolicitud=(select max(idSolicitud) from solicitud);");
        cb.setTextMatrix(370,650);
        cb.showText(datos.get(0));
        //Label actividad
        cb.setFontAndSize(bfNoNegritas,12);
        cb.setTextMatrix(50,600);
        cb.showText("Actividad: ");
        //Actividad base de datos
        cb.setFontAndSize(bf,12);
        datos=conexion.acceder("select actividad from solicitud where idSolicitud=(select max(idSolicitud) from solicitud);");
        acomodar_Actividad(datos.get(0),cb,bf,575);
        //Label pernoctado
        cb.setFontAndSize(bfNoNegritas,12);
        cb.setTextMatrix(50,475);
        cb.showText("Pernoctado: ");
        //Pernoctado base de datos
        cb.setFontAndSize(bf,12);
        datos=conexion.acceder("select pernoctado from solicitud where idSolicitud=(select max(idSolicitud) from solicitud);");
        cb.setTextMatrix(150,475);
        cb.showText(datos.get(0));
        //Vehiculo
        datos=conexion.acceder("select vehiculo from solicitud where idSolicitud=(select max(idSolicitud) from solicitud);");
        if(!datos.get(0).equals("Seleccione el vehículo")){
            //Label vehiculo
            cb.setFontAndSize(bfNoNegritas,12);
            cb.setTextMatrix(50,375);
            cb.showText("Vehiculo: ");
            //Vehiculo base de datos
            cb.setFontAndSize(bf,12);
            cb.setTextMatrix(180,375);
            cb.showText(datos.get(0));
        }
        //Label V° B°
        cb.setFontAndSize(bfNoNegritas,12);
        cb.setTextMatrix(250,275);
        cb.showText("V° B°");
        //Label para firmar
        cb.setTextMatrix(175,225);
        cb.showText("____________________________");
        cb.endText();
        document.close();
            Desktop.getDesktop().open(f);
        }catch(IOException e){
            
        }
    }
    public String acomodar_Actividad(String cad, PdfContentByte cb,BaseFont f,int renglon){
        int contador=0;
        int inicio=0;
        String aux="";
        cb.setFontAndSize(f,12);
        boolean salto=false;
        for(int i=0;i<cad.length();i++){
            contador++;
            if(contador==63 || salto){
                contador=0;
                salto=true;
                if(cad.charAt(i)==' '){
                    cb.setTextMatrix(50,renglon);
                    aux=cad.substring(inicio, i);
                    cb.showText(aux);
                    salto=false;
                    inicio=i+1;
                    renglon-=20;
                }
                
            }
        }
        cb.setTextMatrix(50,renglon);
        aux=cad.substring(inicio, cad.length());
        cb.showText(aux);
        return aux;
    }
    public void pdfFolio(String folio) throws DocumentException{
        String path="C:\\Nueva carpeta\\prueba.pdf";
        try{
        File f=new File(path);
        f.delete();
        Document document=new Document(PageSize.A4,0f,0f,0f,0f);
        PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream(path));
        ArrayList<String> datos;
        Conexion conexion=new Conexion();
        conexion.conexion();
        document.open();
        BaseFont bf=BaseFont.createFont(BaseFont.COURIER_BOLD,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
        BaseFont bfNoNegritas=BaseFont.createFont(BaseFont.COURIER,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
        PdfContentByte cb=writer.getDirectContent();
        cb.setFontAndSize(bf,16);
        Image image=Image.getInstance(getClass().getResource("/Imagenes/icono.png"));
        document.add(image);
        cb.beginText();
        //Label Folio
        cb.setFontAndSize(bfNoNegritas, 12);
        cb.setTextMatrix(480,800);
        cb.showText("Folio: ");
        //Folio base de datos
        cb.setFontAndSize(bf, 12);
        cb.setTextMatrix(525,800);
        datos=conexion.acceder("select folio from oficio_comision where folio="+folio);
        cb.showText(datos.get(0));
        //Label solicitud de viáticos
        cb.setFontAndSize(bf,18);
        cb.setTextMatrix(250,700);
        cb.showText("Viáticos");
        //Label nombre
        cb.setFontAndSize(bfNoNegritas, 12);
        cb.setTextMatrix(50,650);
        cb.showText("Nombre: ");        
        //Nombre base de datos
        cb.setFontAndSize(bf,12);
        cb.setTextMatrix(105,650);
        datos=conexion.acceder("select S.nombre from solicitud S INNER JOIN oficio_comision O ON S.idSolicitud=O.Solicitud_idSolicitud WHERE folio="+folio);
        cb.showText(datos.get(0));
        //Label puesto
        cb.setFontAndSize(bfNoNegritas, 12);
        cb.setTextMatrix(50,600);
        cb.showText("Puesto: ");
        //Puesto base de datos
        cb.setFontAndSize(bf, 12);
        cb.setTextMatrix(105,600);
        datos=conexion.acceder("select S.puesto from solicitud S INNER JOIN oficio_comision O ON S.idSolicitud=O.Solicitud_idSolicitud WHERE folio="+folio);
        cb.showText(datos.get(0));
        //Label descripción
        cb.setFontAndSize(bfNoNegritas, 12);
        cb.setTextMatrix(50,550);
        cb.showText("Con base en el oficio de comisión se autoriza la cantidad de: ");
        //Monto base de datos
        cb.setFontAndSize(bf,10);
        datos=conexion.acceder("select O.monto from solicitud S INNER JOIN oficio_comision O ON S.idSolicitud=O.Solicitud_idSolicitud WHERE folio="+folio);
        cb.showText("$"+datos.get(0));
        //Label motivo
        cb.setFontAndSize(bfNoNegritas,12);
        cb.setTextMatrix(50,500);
        cb.showText("Con motivo de: ");
        //Motivo base de datos
        cb.setFontAndSize(bf,12);
        datos=conexion.acceder("select S.actividad from solicitud S INNER JOIN oficio_comision O ON S.idSolicitud=O.Solicitud_idSolicitud WHERE folio="+folio);
        acomodar_Actividad(datos.get(0),cb,bf,480);
        //Label localidad
        cb.setFontAndSize(bfNoNegritas,12);
        cb.setTextMatrix(50,400);
        cb.showText("Para llevar a cabo la visita de trabajo en la localidad de:");
        //Localidad base de datos
        cb.setFontAndSize(bf,12);
        cb.setTextMatrix(50,380);
        datos=conexion.acceder("select S.lugar from solicitud S INNER JOIN oficio_comision O ON S.idSolicitud=O.Solicitud_idSolicitud WHERE folio="+folio);
        cb.showText(datos.get(0));
        //Vehiculo
        datos=conexion.acceder("select S.vehiculo from solicitud S INNER JOIN oficio_comision O ON S.idSolicitud=O.Solicitud_idSolicitud WHERE folio="+folio);
        int espacio=0;
        if(!datos.get(0).equals("Seleccione el vehículo")){
            //Label vehiculo
            cb.setFontAndSize(bfNoNegritas,12);
            cb.setTextMatrix(50,330);
            cb.showText("Con el vehículo oficial asignado: ");
            //Vehiculo base de datos
            cb.setFontAndSize(bf,12);
            cb.setTextMatrix(50,310);
            cb.showText(datos.get(0));
            espacio=-60;
        }
        //Label periodo
        cb.setFontAndSize(bfNoNegritas,12);
        cb.setTextMatrix(50,330+espacio);
        cb.showText("Entre los dias: ");
        //Fecha salida base de datos
        cb.setFontAndSize(bf,12);
        cb.setTextMatrix(160,330+espacio);
        datos=conexion.acceder("select S.fecha_salida from solicitud S INNER JOIN oficio_comision O ON S.idSolicitud=O.Solicitud_idSolicitud WHERE folio="+folio);
        cb.showText(datos.get(0));
        //Label al
        cb.setFontAndSize(bfNoNegritas, 12);
        cb.setTextMatrix(240,330+espacio);
        cb.showText(" al ");
        //Fecha llegada base de datos
        cb.setFontAndSize(bf, 12);
        cb.setTextMatrix(270,330+espacio);
        datos=conexion.acceder("select S.fecha_llegada from solicitud S INNER JOIN oficio_comision O ON S.idSolicitud=O.Solicitud_idSolicitud WHERE folio="+folio);
        cb.showText(datos.get(0));
        //Label pernoctado
        cb.setFontAndSize(bfNoNegritas, 12);
        cb.setTextMatrix(360,330+espacio);
        cb.showText("Pernoctado: ");
        //Pernoctado base de datos
        cb.setFontAndSize(bf, 12);
        cb.setTextMatrix(445,330+espacio);
        datos=conexion.acceder("select S.pernoctado from solicitud S INNER JOIN oficio_comision O ON S.idSolicitud=O.Solicitud_idSolicitud WHERE folio="+folio);
        cb.showText(datos.get(0));
        //Label firma de recibido
        cb.setFontAndSize(bfNoNegritas, 12);
        cb.setTextMatrix(100,230+espacio);
        cb.showText("Firma de recibido");
        //Label firma de autorizado
        cb.setTextMatrix(350,230+espacio);
        cb.showText("Firma de autorizado");
        //Label linea de firma
        cb.setTextMatrix(70,160+espacio);
        cb.showText("__________________________");
        cb.setTextMatrix(320,160+espacio);
        cb.showText("__________________________");
        //Label comisionado
        cb.setTextMatrix(120,140+espacio);
        cb.showText("Comisionado");
        //Presidente base de datos
        cb.setFontAndSize(bf, 12);
        cb.setTextMatrix(320,140+espacio);
        datos=conexion.acceder("select * from director_general");
        cb.showText(datos.get(0));
        //Label presidente
        cb.setFontAndSize(bfNoNegritas,12);
        cb.setTextMatrix(350,120+espacio);
        cb.showText("Consejero presidente");
        
        
        //Fin del contenido
        cb.endText();
        document.close();
            Desktop.getDesktop().open(f);
        }catch(IOException e){
            
        }
    }
    public void oficio_comision(String folio) throws DocumentException{
        String path="C:\\Nueva carpeta\\prueba.pdf";
        try{
            File f=new File(path);
            //f.delete();
            Document document=new Document(PageSize.A4,0f,0f,0f,0f);
            PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream(path));
            ArrayList<String> datos;
            Conexion conexion=new Conexion();
            conexion.conexion();
            document.open();
            BaseFont bf=BaseFont.createFont(BaseFont.COURIER_BOLD,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
            BaseFont bfNoNegritas=BaseFont.createFont(BaseFont.COURIER,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
            PdfContentByte cb=writer.getDirectContent();
            cb.setFontAndSize(bf,16);
            Image image=Image.getInstance(getClass().getResource("/Imagenes/icono.png"));
            document.add(image);
            cb.beginText();
            //Label Folio
            cb.setFontAndSize(bfNoNegritas, 12);
            cb.setTextMatrix(480,800);
            cb.showText("Folio: ");
            //Folio base de datos
            cb.setFontAndSize(bf, 12);
            cb.setTextMatrix(525,800);
            datos=conexion.acceder("select folio from oficio_comision where folio="+folio);
            cb.showText(datos.get(0));
            //Label oficio de comisión
            cb.setFontAndSize(bfNoNegritas, 16);
            cb.setTextMatrix(200,750);
            cb.showText("Oficio de comisión");
            //Label nombre
            cb.setFontAndSize(bfNoNegritas, 12);
            cb.setTextMatrix(50,700);
            cb.showText("Nombre:");
            //Nombre base de datos
            cb.setFontAndSize(bf, 12);
            cb.setTextMatrix(120,700);
            datos=conexion.acceder("select S.nombre from solicitud S INNER JOIN oficio_comision O ON S.idSolicitud=O.Solicitud_idSolicitud WHERE folio="+folio);
            cb.showText(datos.get(0));
            //Label puesto
            cb.setFontAndSize(bfNoNegritas, 12);
            cb.setTextMatrix(50,675);
            cb.showText("Puesto:");
            //Puesto base de datos
            int size=12;
            cb.setFontAndSize(bf, 12);
            cb.setTextMatrix(120,675);
            datos=conexion.acceder("select S.puesto from solicitud S INNER JOIN oficio_comision O ON S.idSolicitud=O.Solicitud_idSolicitud WHERE folio="+folio);
            cb.showText(datos.get(0));
            //Label presente
            cb.setFontAndSize(bfNoNegritas, 16);
            cb.setTextMatrix(50,625);
            cb.showText("PRESENTE:");
            //Label lugar y fecha
            cb.setFontAndSize(bfNoNegritas, size);
            cb.setTextMatrix(50,600);
            cb.showText("Con este lugar y fecha: ");
            //Label lugar
            cb.setFontAndSize(bf,size);
            cb.setTextMatrix(220,600);
            Calendar cal= Calendar.getInstance();
            String fecha="";
            fecha=cal.get(cal.DATE)+"/"+(cal.get(cal.MONTH)+1)+"/"+cal.get(cal.YEAR);
            cb.showText("Tepic, Nayarit, "+fecha);
            //Label descripción
            String cad="Ha sido comisionado por el suscrito, a efecto de llevar a cabo visita de trabajo: ";
            acomodar_Actividad(cad,cb,bfNoNegritas,550);
            //Label desde los dias
            cb.setFontAndSize(bfNoNegritas, size);
            cb.setTextMatrix(50,500);
            cb.showText("Desde los días ");
            //Fecha salida base de datos
            cb.setFontAndSize(bf, size);
            cb.setTextMatrix(160,500);
            datos=conexion.acceder("select S.fecha_salida from solicitud S INNER JOIN oficio_comision O ON S.idSolicitud=O.Solicitud_idSolicitud WHERE folio="+folio);
            cb.showText(datos.get(0));
            //Label al
            cb.setFontAndSize(bfNoNegritas, size);
            cb.setTextMatrix(240,500);
            cb.showText("al");
            //Fecha llegada base de datos
            cb.setFontAndSize(bf, size);
            cb.setTextMatrix(265,500);
            datos=conexion.acceder("select S.fecha_llegada from solicitud S INNER JOIN oficio_comision O ON S.idSolicitud=O.Solicitud_idSolicitud WHERE folio="+folio);
            cb.showText(datos.get(0));
            //Label en la localidad de
            cb.setFontAndSize(bfNoNegritas, size);
            cb.setTextMatrix(50,475);
            cb.showText("En la localida de:");
            //Lugar base de datos
            cb.setFontAndSize(bf, size);
            cb.setTextMatrix(185,475);
            datos=conexion.acceder("select S.lugar from solicitud S INNER JOIN oficio_comision O ON S.idSolicitud=O.Solicitud_idSolicitud WHERE folio="+folio);
            cb.showText(datos.get(0));
            //Label que consiste en:
            cb.setFontAndSize(bfNoNegritas, size);
            cb.setTextMatrix(50,450);
            cb.showText("Que consiste en:");
            //Actividad base de datos
            cb.setFontAndSize(bf, size);
            cb.setTextMatrix(180,450);
            datos=conexion.acceder("select S.actividad from solicitud S INNER JOIN oficio_comision O ON S.idSolicitud=O.Solicitud_idSolicitud WHERE folio="+folio);
            acomodar_Actividad(datos.get(0),cb,bf,425);
            datos=conexion.acceder("select S.vehiculo from solicitud S INNER JOIN oficio_comision O ON S.idSolicitud=O.Solicitud_idSolicitud WHERE folio="+folio);
            //Vehiculo
            int espacio=0;
            if(!datos.get(0).equals("Seleccione el vehículo")){
                espacio=-60;
                cb.setFontAndSize(bfNoNegritas, size);
                cb.setTextMatrix(50,350);
                cb.showText("Vehiculo:");
                //Vehiculo base de datos
                cb.setFontAndSize(bf, size);
                cb.setTextMatrix(150,350);
                cb.showText(datos.get(0));
            }
            //Label autorizado
            cb.setFontAndSize(bfNoNegritas, size);
            cb.setTextMatrix(230,350+espacio);
            cb.showText("Firma autorizado");
            //Label linea
            cb.setTextMatrix(200,280+espacio);
            cb.showText("_________________________");
            //Director general
            cb.setFontAndSize(bf, size);
            cb.setTextMatrix(190,260+espacio);
            datos=conexion.acceder("select * from director_general");
            cb.showText(datos.get(0));
            //Label consejero presidente
            cb.setFontAndSize(bfNoNegritas, size);
            cb.setTextMatrix(210,240+espacio);
            cb.showText("Consejero presidente");
            
            
            
            //Fin del contenido
            cb.endText();
            document.close();
            Desktop.getDesktop().open(f);
        }catch(IOException e){
            
        }
    }
    public static void main(String[] args){
        CrearPDF a=new CrearPDF();
        try{
            a.oficio_comision("1");
        }catch(Exception e){}
    }
}

