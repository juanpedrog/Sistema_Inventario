
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
        String path="C:\\Users\\Juan Pedro Gil\\Desktop\\prueba.pdf";
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
        Image image=Image.getInstance("C:\\Users\\Juan Pedro Gil\\Documents\\GitHub\\Sistema_Viaticos\\ProyectoGPS\\src\\Imagenes\\icono.png");
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
        String path="C:\\Users\\Juan Pedro Gil\\Desktop\\prueba.pdf";
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
        Image image=Image.getInstance("C:\\Users\\Juan Pedro Gil\\Documents\\GitHub\\Sistema_Viaticos\\ProyectoGPS\\src\\Imagenes\\icono.png");
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
        //Label fecha salida
        cb.setFontAndSize(bf,12);
        cb.setTextMatrix(90,330+espacio);
        datos=conexion.acceder("select S.fecha_salida from solicitud S INNER JOIN oficio_comision O ON S.idSolicitud=O.Solicitud_idSolicitud WHERE folio="+folio);
        cb.showText(datos.get(0));
        
        //Fin del contenido
        cb.endText();
        document.close();
            Desktop.getDesktop().open(f);
        }catch(IOException e){
            
        }
    }
}

