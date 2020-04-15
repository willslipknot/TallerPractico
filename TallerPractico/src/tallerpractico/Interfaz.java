package tallerpractico;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author kevin
 */
public class Interfaz extends JFrame implements ActionListener{
    JPanel p1, p2, p3;
    JLabel titulo, l2, l3, l4, l5, l6, l7, l8, l9, espacio;
    JTextArea reseña;
    JTextField t1, entradas, nombre, director, year, cantidad, totalbol;
    JButton verPeliculas, verificar, comprar, total;
    ArrayList listaP;
    
    public static void main(String[] args) {
        // Creacion de los objetos de la lista
        DatosPelicula uno = new DatosPelicula("Back to the future", "Robert Zemeckis", 1985, "Marty McFly \nviaja en el tiempo...");
        DatosPelicula dos = new DatosPelicula("Terminator", "James Cameron", 1984, "En un futuro cercano\nSkinet...");
        DatosPelicula tres = new DatosPelicula("Toy story", "Josh Cooley", 1995, "Juguetes que tienen a\nvida y se ocultan...");
        DatosPelicula cuatro = new DatosPelicula("Constantine", "Francis Lawrence", 2005, "Un exorcista\nse enfrenta a el hijo...");
        DatosPelicula cinco = new DatosPelicula("Avengers", "Joss Whedon", 2012, "Heroes reunidos\npara combatir contra...");
        DatosPelicula seis = new DatosPelicula("Marley y yo", "David Frankel", 2008, "Una pareja y una\nperrita que los une...");
        DatosPelicula siete = new DatosPelicula("Green Street Hooligans", "Lexi Alexander", 2004, "Hooligans defienden,\nsu honor por su equipo...");
        DatosPelicula ocho = new DatosPelicula("American Pie", "Jon Hurwitz", 1999, "Jovenes haciendo \nidioteces tipicas...");
        DatosPelicula nueve = new DatosPelicula("Saw", "Michael Spierig", 2004, "Un juego donde se dicide\nsi merecen otra oportunidad...");
        DatosPelicula diez = new DatosPelicula("Jhon Wick", "Chad Stahelski", 2014, "un sicario que regres\ntras la muerte de...");
        
        //Instanciando la lista
        ArrayList lista = new ArrayList();
        //Agregando datos
        lista.add(uno);
        lista.add(dos);
        lista.add(tres);
        lista.add(cuatro);
        lista.add(cinco);
        lista.add(seis);
        lista.add(siete);
        lista.add(ocho);
        lista.add(nueve);
        lista.add(diez);

        Interfaz inter = new Interfaz(lista);
    }
    public Interfaz(ArrayList list){
        this.setTitle("CARTELERA");
        setBounds(120, 70, 450, 520);
        setResizable(false);
        setLayout(new BorderLayout(20, 20));
        
        listaP=list;
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        
        
        espacio = new JLabel("                                                          ");
        l2 = new JLabel("Pelicula:");
        l3 = new JLabel("                       Entradas:");
        l4 = new JLabel("Nombre:");
        l5 = new JLabel("Director:");
        l6 = new JLabel("Año:");
        l7 = new JLabel("Reseña:");
        l8 = new JLabel("Cantidad de boletos:");
        l9 = new JLabel("Total Boletos : ");
        
        
        t1 = new JTextField(12);
        entradas  = new JTextField("0", 12);
        nombre = new JTextField(12);
        director = new JTextField(12);
        year = new JTextField(12);
        reseña = new JTextArea(3, 12);
        cantidad = new JTextField("0",12);
        totalbol = new JTextField("0",8);
        
        verPeliculas = new JButton("CARTELERA");
        verPeliculas.addActionListener(this);
        verPeliculas.setActionCommand("cartelera");
        verificar = new JButton("            Verificar                    ");
        verificar.addActionListener(this);
        verificar.setActionCommand("buscar en lista");
        comprar = new JButton("     Adquirir Boletas     ");
        comprar.addActionListener(this);
        comprar.setActionCommand("comprar");
        total = new JButton("Calcular");
        total.addActionListener(this);
        total.setActionCommand("total");
        
        p1.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
        p2.setLayout(new FlowLayout(FlowLayout.TRAILING, 80, 10));
        p3.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 12));
        p1.setBackground(Color.blue);
        p2.setBackground(Color.white);
        p3.setBackground(Color.blue);
        
        
        p1.add(verPeliculas);
        
        p2.add(l2);
        p2.add(t1);
        p2.add(verificar);
        p2.add(l3);
        p2.add(entradas);
        p2.add(l4);
        p2.add(l4);
        p2.add(nombre);
        p2.add(l5);
        p2.add(director);
        p2.add(l6);
        p2.add(year);
        p2.add(l7);
        p2.add(reseña);
        p2.add(espacio);
        p2.add(l8);
        p2.add(cantidad);
        p2.add(comprar);
        
        p3.add(l9);
        p3.add(totalbol);
        p3.add(total);
        
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);
        
        
       setVisible(true);
    }

    public ArrayList obtenerArray(ArrayList list){
        return list;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "cartelera":
                String cartelera="\n ";
              
                        Iterator it = listaP.iterator();
                while ( it.hasNext() ) { 
                    DatosPelicula objeto = (DatosPelicula)it.next(); 
                  
                    cartelera+="\n"+objeto.getNombre();
                } 
                JOptionPane.showMessageDialog(null, cartelera);
                ;break;
            case "buscar en lista":
                
                if(buscarPelicula()){
                   
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Pelicula no encontrada.");
                }
                
                ;break;
            case "comprar":
                
            
                if(comprar()){
                    JOptionPane.showMessageDialog(null, "Compra realizada con exito.");
                }else{
                    JOptionPane.showMessageDialog(null, "Error en la compra, vuelva a intentarlo.");
                }
                ;break; 
            case "total":
    
                int cont = 0;
                it = listaP.iterator();
                while ( it.hasNext() ) { 
                    DatosPelicula objeto = (DatosPelicula)it.next(); 
                    cont+=objeto.getCantidad();
                }
                totalbol.setText(String.valueOf(cont));
                ;break; 
        }
    }
    public boolean buscarPelicula(){
        String pelicula = t1.getText();
        boolean v = false;
        Iterator it = listaP.iterator();
        while ( it.hasNext() ) { 
            DatosPelicula objeto = (DatosPelicula)it.next(); 
            if(objeto.getNombre().equalsIgnoreCase(pelicula)){
           
            nombre.setText(objeto.getNombre());
            director.setText(objeto.getDirector());
            year.setText(String.valueOf(objeto.getYear()));
            reseña.setText(objeto.getResena());
            entradas.setText(String.valueOf(objeto.getCantidad()));
            v=true;
            return v;
            }    
        } 
        return v;
    }
    
    public boolean comprar(){
        String pelicula = nombre.getText();
        int cont = 0;
        boolean v = false;
        Iterator it = listaP.iterator();
        while ( it.hasNext() ) { 
            DatosPelicula objeto = (DatosPelicula)it.next(); 
            if(objeto.getNombre().equalsIgnoreCase(pelicula)){
                objeto.setCantidad(objeto.getCantidad()+ Integer.parseInt(cantidad.getText()) );
                entradas.setText(String.valueOf(objeto.getCantidad()));
                v=true;
                return v;
            }    
        } 
        return v;
    }
    
    
}