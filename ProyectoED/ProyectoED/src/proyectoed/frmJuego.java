/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


package proyectoed;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import proyectoed.*;
import proyectoed.ListaZombies.NodoZombie;

public class frmJuego extends javax.swing.JFrame {
    // Variables del juego
    private int segundosTranscurridos = 0;
    private int monedas = 800;
    private JPanel[][] tablero;
    private Timer timer;
    private Cola colaZombies;
    private String usuario;
    private JLabel lbMonedas;
    private String plantaSeleccionada;
    private int costoPlantaSeleccionada;
    private JPanel panelJuego;
    private JPanel panelLateral;

    public frmJuego() {
        initComponents(); // Asegúrate de que esta línea esté
    // Configuración adicional (opcional)
    setTitle("Juego Adventure");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    pack(); // Ajusta el tamaño automáticamente
    setVisible(true); // Si no se llama en el ActionPerformed
    }

    private void iniciarTemporizador() {
        
    }

    private void generarOleada(int i) {
       
    }

    private void actualizaZombies() {
        
    }

    // Clase interna para la cola de zombies
    private class Cola {
        private class Nodo {
            Zombies zombie;
            Nodo siguiente;
        }
        
        private Nodo primero;
        private Nodo ultimo;
        
        public void encolar(Zombies zom) {
            Nodo nuevo = new Nodo();
            nuevo.zombie = zom;
            
            if (primero == null) {
                primero = ultimo = nuevo;
            } else {
                ultimo.siguiente = nuevo;
                ultimo = nuevo;
            }
        }
        public Zombies desencolar() {
            if (primero == null) return null;
            Zombies zom = primero.zombie;
            primero = primero.siguiente;
            if (primero == null) ultimo = null;
            return zom;
        }
        public boolean estaVacia() {
            return primero == null;
        }
    }
    
    
    public frmJuego(String usuario) {
        this.usuario = usuario;
        initComponents();
        configurarInterfaz();
        iniciarJuego();
    }
    private void configurarInterfaz() {
        setTitle("Plants-Fide - Jugador: " + usuario);
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
    }
    private void iniciarJuego() {
        // Inicializar componentes
        colaZombies = new Cola();
        lbMonedas = new JLabel("Monedas: " + monedas);
        lbTiempo = new JLabel("Tiempo: 0 segundos");
        
        // Configurar paneles principales
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelSuperior.add(lbMonedas);
        panelSuperior.add(lbTiempo);
        
        JPanel panelCentral = new JPanel(new BorderLayout());
        panelLateral = new JPanel(new GridLayout(5, 1, 0, 10));
        panelLateral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Inicializar tablero 5x9
        inicializarTablero();
        panelCentral.add(panelJuego, BorderLayout.CENTER);
        
        // Añadir plantas disponibles
        inicializarPlantasDisponibles(panelLateral);
        
        // Añadir paneles al frame principal
        add(panelSuperior, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        add(panelLateral, BorderLayout.EAST);
        
        // Iniciar temporizador
        iniciarTemporizador();
        
        // Generar primera oleada
        generarOleada(1);
    }

    
    
    private void inicializarTablero() {
        panelJuego = new JPanel(new GridLayout(5, 9, 2, 2));
        tablero = new JPanel[5][9];
        
        for (int fila = 0; fila < 5; fila++) {
            for (int col = 0; col < 9; col++) {
                JPanel celda = new JPanel(new BorderLayout());
                celda.setBackground(new Color(100, 200, 100));
                celda.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                
                // Permitir colocar plantas
                celda.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        colocarPlanta(e.getComponent());
                    }
                });
                
                tablero[fila][col] = celda;
                panelJuego.add(celda);
            }
        }
    }

    private void inicializarPlantasDisponibles(JPanel panelLateral) {
        // Planta 1: Peashooter (250 monedas)
        JLabel lblPeashooter = crearBotonPlanta("Peashooter", 250, "/proyectoed/img/pea-shooter-plant-vs-zombie-ezgif.com-resize.gif");
        
        // Planta 2: BokChoy (400 monedas)
        JLabel lblBokChoy = crearBotonPlanta("BokChoy", 400, "/proyectoed/img/bokchoy-ezgif.com-resize (1).gif");
        
        panelLateral.add(lblPeashooter);
        panelLateral.add(lblBokChoy);
    }

    private JLabel crearBotonPlanta(String nombre, int costo, String rutaImagen) {
        JLabel lblPlantaUno = new JLabel(nombre + " (" + costo + ")", SwingConstants.CENTER);
       lblPlantaUno.setOpaque(true);
       lblPlantaUno.setBackground(new Color(200, 240, 200));
       lblPlantaUno.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
       lblPlantaUno.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        // Configurar drag and drop
        lblPlantaUno.setTransferHandler(new TransferHandler("icon"));
        lblPlantaUno.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (monedas >= costo) {
                    plantaSeleccionada = nombre;
                    costoPlantaSeleccionada = costo;
                    
                    // Crear imagen para arrastrar
                    ImageIcon icon = new ImageIcon(getClass().getResource(rutaImagen));
                    lblPlantaUno.setIcon(icon);
                    
                    JComponent comp = (JComponent) e.getSource();
                    TransferHandler handler = comp.getTransferHandler();
                    handler.exportAsDrag(comp, e, TransferHandler.COPY);
                } else {
                    
                }
            }
        });
        
        return lblPlantaUno;
    }

    private void colocarPlanta(Component componente) {
        if (plantaSeleccionada != null && monedas >= costoPlantaSeleccionada) {
            JPanel celda = (JPanel) componente;
            
            // Verificar si la celda está vacía
            if (celda.getComponentCount() == 0) {
                // Crear la imagen de la planta
                String rutaImagen = "";
                if (plantaSeleccionada.equals("Peashooter")) {
                    rutaImagen = "/proyectoed/img/Peashooter (1).png";
                } else if (plantaSeleccionada.equals("BokChoy")) {
                    rutaImagen = "/proyectoed/img/BokChoy (1).png";
                }
                
                ImageIcon icon = new ImageIcon(getClass().getResource(rutaImagen));
                JLabel lblPlanta = new JLabel(icon);
                celda.add(lblPlanta);
                
                // Restar monedas
                monedas -= costoPlantaSeleccionada;
                lbMonedas.setText("Monedas: " + monedas);
                
                // Actualizar la celda
                celda.revalidate();
                celda.repaint();
                
                // Lógica adicional según el tipo de planta
                if (plantaSeleccionada.equals("Peashooter")) {
                    // Iniciar temporizador de disparos
                }
            }
            
            plantaSeleccionada = null;
        }
    }
    
   ListaZombies zombies = new ListaZombies();

public void nuevaOleada() {
    for (int i = 0; i < 3; i++) { // Por ejemplo, 3 zombies por oleada
        int fila = (int) (Math.random() * 5);
        Zombies zom = new Zombies();
        zom.setFila(fila);
        zom.setColumna(8); // Posición inicial
        zombies.agregar(zom);
        colocarZombieEnCelda(zom);
    }
}

public void colocarZombieEnCelda(Zombies zom) {
    JLabel celda = obtenerCelda(zom.getFila(), zom.getColumna());
    celda.setIcon(zom.getImagen());
}

public void caminaZombie() {
    NodoZombie actual = zombies.cabeza;
    while (actual != null) {
        Zombies zom = actual.zombie;
        int fila = zom.getFila();
        int col = zom.getColumna();

        JLabel celdaActual = obtenerCelda(fila, col);
        celdaActual.setIcon(null);

        if (col > 0) {
            zom.setColumna(col - 1);
            JLabel nuevaCelda = obtenerCelda(fila, col - 1);
            nuevaCelda.setIcon(zom.getImagen());
        } else {
            // El zombie llegó al final
            mostrarMensajeFinJuego();
        }
        actual = actual.siguiente;
    }
}

private void moverZombies() {
        if (!colaZombies.estaVacia()) {
            Zombies zom = colaZombies.desencolar();
            // Lógica para mover zombies en el tablero
        }
    }

public void actualizarZombies() {
    caminaZombie();
    // En futuras versiones podrías detectar colisiones con plantas aquí

 timer = new Timer(1000, e -> {
        actualizaZombies();  // o lo que sea tu lógica
    });
    timer.start(); // ✅ esta línea ya debe funcionar bien
}


public JLabel obtenerCelda(int fila, int col) {
    Component[] componentes = panelJuego.getComponents();
    for (int i = 0; i < componentes.length; i++) {
        int f = i / 9;
        int c = i % 9;
        if (f == fila && c == col) {
            return (JLabel) componentes[i];
        }
    }
    return null;
}

public void mostrarMensajeFinJuego() {
    // Puedes mostrar un JLabel grande en el panel principal o cambiar a otro panel
    System.out.println("Juego terminado. Un zombie llegó al final.");
}




/*package proyectoed;


import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;


/**
 *
 * @author cheve
 
public class frmJuego extends javax.swing.JFrame {
    private int segundosTranscurridos = 0; 
    private JPanel[][] tablero;
    private JPanel panelJuego;
    private JPanel panelLateral;
    private Timer temporizador;
    private int monedas = 800;
    private Cola colaZombies;
    private String usuario;
    private JLabel lbMonedas;
    private JLabel lblMensaje;
    private String plantaSeleccionada = null;
    private int costoPlantaSeleccionada;
 

    private void initComponents() {
    }

    private String getPlantaSeleccionada() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    //COLA ZOMBIES
    private class Cola {
        private class Nodo{
            Zombies zombie;
            Nodo siguiente;
        }
        private Nodo primero; 
        private Nodo ultimo;
        
        public void encolar (Zombies zom){
            Nodo nuevo = new Nodo();
            nuevo.zombie = zom;
            
            if (primero == null){
                primero = ultimo = nuevo;
            }else {
                ultimo.siguiente= nuevo;
                ultimo = nuevo; 
            }
        }
        
        public Zombies desencolar(){
             if (primero == null) return null;
            
            Zombies z = primero.zombie;
            primero = primero.siguiente;
            if (primero == null) ultimo = null;
            return z;
        }
        
        public boolean estaVacia() {
            return primero == null;
        }
    }
    
    
    public frmJuego() {
        this.usuario = usuario;
        initComponents();     
        configurarInterfaz();
        iniciarJuego();
}
    private void configurarInterfaz() {
        setTitle("Plants-Fide");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
    }
    private void iniciarJuego() {
        
        // INICIALIZA COMPONENTES
        colaZombies = new Cola();
        lbMonedas = new JLabel("Monedas: " + monedas);
        lbTiempo = new JLabel("Tiempo: 0 segundos");
        
        // PANELES PRINCIPALES
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelSuperior.add(lbMonedas);
        panelSuperior.add(lbTiempo);
        
        JPanel panelCentral = new JPanel(new BorderLayout());
        JPanel panelLateral = new JPanel(new GridLayout(5, 1, 0, 10));
        panelLateral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        //TABLERO
        inicializarTablero();
        panelCentral.add(panelJuego, BorderLayout.CENTER);
        
        inicializarPlantasDisponibles(panelLateral);
        
        
        // Añadir paneles al frame principal
        add(panelSuperior, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        add(panelLateral, BorderLayout.EAST);
        
        //Iniciar temporizador
        iniciarTemporizador();
        
        // Generar primera oleada
        generarOleada(1);

}
    private void inicializarTablero() {
        panelJuego = new JPanel(new GridLayout(5, 9, 2, 2));
        tablero = new JPanel[5][9];
        
        for (int fila = 0; fila < 5; fila++) {
            for (int col = 0; col < 9; col++) {
                JPanel celda = new JPanel(new BorderLayout());
                celda.setBackground(new Color(100, 200, 100));
                celda.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                
                // Permitir colocar plantas
                celda.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        colocarPlanta(e.getComponent());
                    }
                });
                
                tablero[fila][col] = celda;
                panelJuego.add(celda);
            }
        }
    }
private void inicializarPlantasDisponibles(JPanel panelLateral) {
        // Planta 1: Peashooter (250 monedas)
        JLabel lblPlantaUno = crearBotonPlanta("Peashooter", 250, "/proyectoed/img/pea-shooter-vs-zombie-ezgif.com-resize.gif");
        // Planta 2: BokChoy (400 monedas)
        JLabel lblPlantaDos = crearBotonPlanta("BokChoy", 400, "/proyectoed/img/bokChoy-ezgif.com-resize.gif");
        
        panelLateral.add(lblPlantaUno);
        panelLateral.add(lblPlantaDos);
    }
private JLabel crearBotonPlanta(String nombre, int costo, String rutaImagen) {
        JLabel lblPlanta = new JLabel(nombre + " (" + costo + ")", SwingConstants.CENTER);
        lblPlanta.setOpaque(true);
        lblPlanta.setBackground(new Color(200, 240, 200));
        lblPlanta.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        lblPlanta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        // Configurar drag and drop
        lblPlanta.setTransferHandler(new TransferHandler("icon"));
        lblPlanta.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (monedas >= costo) {
                    plantaSeleccionada = nombre;
                    costoPlantaSeleccionada = costo;
                    
                    // Crear imagen para arrastrar
                    ImageIcon icon = new ImageIcon(getClass().getResource(rutaImagen));
                    lblPlanta.setIcon(icon);
                    
                    JComponent comp = (JComponent) e.getSource();
                    TransferHandler handler = comp.getTransferHandler();
                    handler.exportAsDrag(comp, e, TransferHandler.COPY);
                } else {
                    JOptionPane.showMessageDialog(frmJuego.this, 
                        "No tienes suficientes monedas", 
                        "Error", 
                        JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        return lblPlanta;
    }
private void colocarPlanta(Component componente) {
        if (plantaSeleccionada != null && monedas >= costoPlantaSeleccionada) {
            JPanel celda = (JPanel) componente;
            
            // Verificar si la celda está vacía
            if (celda.getComponentCount() == 0) {
                // Crear la imagen de la planta
                String rutaImagen = "";
                if (plantaSeleccionada.equals("Peashooter")) {
                    rutaImagen = "/proyectoed/img/Peashooter (1).png";
                } else if (plantaSeleccionada.equals("BokChoy")) {
                    rutaImagen = "/proyectoed/img/BokChoy (1).png";
                }
                
                ImageIcon icon = new ImageIcon(getClass().getResource(rutaImagen));
                JLabel lblPlanta = new JLabel(icon);
                celda.add(lblPlanta);
                
                // Restar monedas
                monedas -= costoPlantaSeleccionada;
                lbMonedas.setText("Monedas: " + monedas);
                
                // Actualizar la celda
                celda.revalidate();
                celda.repaint();
                
                // Lógica adicional según el tipo de planta
                if (plantaSeleccionada.equals("Peashooter")) {
                    // Iniciar temporizador de disparos
                }
            }
            
            plantaSeleccionada = null;
        }
    }
private void generarOleada(int numeroOleada) {
        int cantidad = (numeroOleada * 2) + 3; // Fórmula del proyecto
        
        for (int i = 0; i < cantidad; i++) {
            Zombies zom = new Zombies(6, 3); // Zombie con 6 de vida y 3 de ataque
            colaZombies.encolar(zom);
        }
        
        actualizarUIZombies();
    }

    private void actualizarUIZombies() {
        // Implementar lógica para mostrar próximos zombies
    }

    private void iniciarTemporizador() {
        Timer timer = new Timer(1000, e -> {
        segundosTranscurridos++;
        lbTiempo.setText("Tiempo: " + segundosTranscurridos + " segundos");

    // Cada 10 segundos, mover zombies
    if (segundosTranscurridos % 10 == 0) {
       moverZombies();
    }

    // Cada 5 oleadas, aumentar dificultad
    if (segundosTranscurridos % 60 == 0) {
        int oleadaActual = segundosTranscurridos / 60 + 1;
        generarOleada(oleadaActual);
      }
     });
     timer.start();
    }

 private void moverZombies() {
        if (!colaZombies.estaVacia()) {
            Zombies zom = colaZombies.desencolar();
            // Lógica para mover zombies en el tablero
        }
    }

*/
        
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        btnMenu = new javax.swing.JButton();
        cantMonedas = new javax.swing.JLabel();
        jblPlanta02 = new javax.swing.JLabel();
        jlbPlanta01 = new javax.swing.JLabel();
        jlbMoneda = new javax.swing.JLabel();
        lblZombieAlien1 = new javax.swing.JLabel();
        lblZombieNormal2 = new javax.swing.JLabel();
        lblZombieAlien3 = new javax.swing.JLabel();
        lblPlantaDos = new javax.swing.JLabel();
        lblPlantaUno = new javax.swing.JLabel();
        lbTiempo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMenu.setBorder(null);
        btnMenu.setContentAreaFilled(false);
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 80, 180, 30));
        jLayeredPane1.add(cantMonedas, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 40, 20));

        jblPlanta02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoed/img/bokchoy-ezgif.com-resize (1).gif"))); // NOI18N
        jLayeredPane1.add(jblPlanta02, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        jlbPlanta01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoed/img/pea-shooter-plant-vs-zombie-ezgif.com-resize.gif"))); // NOI18N
        jLayeredPane1.add(jlbPlanta01, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, -1, -1));

        jlbMoneda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoed/img/monedaPeq.png"))); // NOI18N
        jlbMoneda.setText("jLabel5");
        jLayeredPane1.add(jlbMoneda, new org.netbeans.lib.awtextra.AbsoluteConstraints(-140, 50, 280, 230));

        lblZombieAlien1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoed/img/Zombie.png"))); // NOI18N
        lblZombieAlien1.setText("jLabel7");
        jLayeredPane1.add(lblZombieAlien1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 140, 100, 140));

        lblZombieNormal2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoed/img/zombieNormal.gif"))); // NOI18N
        jLayeredPane1.add(lblZombieNormal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 460, 180, 140));

        lblZombieAlien3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoed/img/Zombie.png"))); // NOI18N
        lblZombieAlien3.setText("jLabel7");
        jLayeredPane1.add(lblZombieAlien3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 300, 100, 140));

        lblPlantaDos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoed/img/BokChoy (1).png"))); // NOI18N
        jLayeredPane1.add(lblPlantaDos, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, -1, 90));

        lblPlantaUno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoed/img/Peashooter (1).png"))); // NOI18N
        jLayeredPane1.add(lblPlantaUno, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, -1, 90));

        lbTiempo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTiempo.setForeground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.add(lbTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 120, 90, 20));

        jLabel4.setText("jLabel4");
        jLayeredPane1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 420, 110));

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoed/img/ZombieHead.png"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel2.setOpaque(true);
        jLayeredPane1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, -1, 30));

        jProgressBar1.setBackground(new java.awt.Color(0, 153, 51));
        jProgressBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jProgressBar1.setFocusable(false);
        jLayeredPane1.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, 240, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoed/img/FondoNivel.png"))); // NOI18N
        jLayeredPane1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 785));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        frmMenu m = new frmMenu(usuario);
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMenuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
           new frmJuego("Usuario").setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenu;
    private javax.swing.JLabel cantMonedas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jblPlanta02;
    private javax.swing.JLabel jlbMoneda;
    private javax.swing.JLabel jlbPlanta01;
    private javax.swing.JLabel lbTiempo;
    private javax.swing.JLabel lblPlantaDos;
    private javax.swing.JLabel lblPlantaUno;
    private javax.swing.JLabel lblZombieAlien1;
    private javax.swing.JLabel lblZombieAlien3;
    private javax.swing.JLabel lblZombieNormal2;
    // End of variables declaration//GEN-END:variables

}
