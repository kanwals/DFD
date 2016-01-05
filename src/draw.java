
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
class points{
    int x,y;
}
class finalpts{
    int a,b,c,d;
}
class point_count{
    int start, end;
}
class font{
    int f;
}
public class draw extends javax.swing.JFrame implements MouseMotionListener,MouseListener {
           ArrayList <finalpts> fr = new ArrayList<>();
           ArrayList <finalpts> fc = new ArrayList<>();
           ArrayList <finalpts> fa = new ArrayList<>();         
           ArrayList <points> r = new ArrayList<>();
           ArrayList <points> c = new ArrayList<>();
           ArrayList <points> a = new ArrayList<>();
           ArrayList <points> p = new ArrayList<>();
           ArrayList <points> er = new ArrayList<>();
           ArrayList <font> fontpt = new ArrayList<>();
           ArrayList <point_count> pp = new ArrayList<>();
           ArrayList <point_count> pe = new ArrayList<>();
           ArrayList <points> t = new ArrayList<>();
           ArrayList <String> input = new ArrayList<>();
           int r_initx,r_inity,r_finalx,r_finaly;
           int c_initx,c_inity,c_finalx,c_finaly;
           int a_initx,a_inity,a_finalx,a_finaly;
           int p_initx,p_inity,p_finalx,p_finaly;
           int e_initx,e_inity,e_finalx,e_finaly;
           points rectangle,circle,arrow,pencil,eraser;
           int shape=0;
           boolean background_set=false;
           File fileToSet;
    public draw() {
        tools obj = new tools();
        setBackground(Color.white);
        repaint();
        initComponents();
        setSize(1100,720);
        setResizable(false);
        
//                refresh th = new refresh();
//        th.run();
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        update_draw();
    }

    
    public void paint(Graphics g) {
//        setBackground(Color.white);
//        g.drawRect(0,0,0,0);
        
        if(r.size()>1&&shape==1){
            if(r.size()>1)
                g.clearRect(r_initx, r_inity, r.get(r.size()-1).x-r_initx, r.get(r.size()-1).y-r_inity);
            r_finalx=r.get(r.size()-1).x-r_initx;
            r_finaly=r.get(r.size()-1).y-r_inity;
            g.drawRect(r_initx, r_inity, r_finalx, r_finaly);
            
        }
        else if (shape==6&&t.size()>0){
            Font myfont =  new Font("Serif", Font.PLAIN, fontpt.get(fontpt.size()-1).f);
            g.setFont(myfont);
            g.drawString(input.get(input.size()-1), t.get(t.size()-1).x,t.get(t.size()-1).y);
        }
        else if(c.size()>1&&shape==2){
            if(c.size()>1)
                g.clearRect(c_initx, c_inity, c.get(c.size()-1).x-c_initx, c.get(c.size()-1).y-c_inity);
            c_finalx=c.get(c.size()-1).x-c_initx;
            c_finaly=c.get(c.size()-1).y-c_inity;
            g.drawOval(c_initx, c_inity, c_finalx, c_finaly);
            
        }
        else if(a.size()>1&&shape==3){
            if(a.size()>1)
                g.clearRect(a_initx, a_inity, a.get(a.size()-1).x-a_initx, a.get(a.size()-1).y-a_inity);
            a_finalx=a.get(a.size()-1).x;
            a_finaly=a.get(a.size()-1).y;
            g.drawLine(a_initx, a_inity, a_finalx, a_finaly);
            
        }
        else if(p.size()>0&&shape==4){
            int i = pp.get(pp.size()-1).start;
            try {
                do{
                    g.drawLine(p.get(i-1).x,p.get(i-1).y,p.get(i).x,p.get(i).y);
                    i++;
                }while(i!=pp.get(pp.size()-1).end);
            } catch (Exception e) {
            }
        }
        else if(er.size()>0&&shape==5){
            int i = pe.get(pe.size()-1).start;
            g.setColor(Color.white);
            try {
                do{
                    g.fillOval(er.get(i-1).x,er.get(i-1).y,10,10);
                    i++;
                }while(i!=pe.get(pe.size()-1).end);
            } catch (Exception e) {
            }
                
        }
        else if(shape==10){
            try {
                if(background_set){
                    
                BufferedImage image = ImageIO.read(fileToSet);
                g.drawImage(image, 0, 0,1100, 720, rootPane);
//                JLabel label = new JLabel(new ImageIcon(image));
//                add(label);
////                getContentPane().setBackground(Color.white);
//                label.setVisible(true);
//                label.setBounds(0,0,1100,720);
//                    label.setLayout(new BorderLayout());
//                setCursor(java.awt.Cursor.CROSSHAIR_CURSOR);
//                setResizable(true);
//                setSize(1101,720);
//        //        setSize(getSize().height+1,getSize().width+1);
//        //        setSize(getSize().height-1,getSize().width-1);
//                setSize(1100,720);
//                setResizable(false);
//                shape=10;
//                repaint();
                }
            } catch (Exception e) {
            }
            int i =0;
            while(fr.size()>i){
                g.drawRect(fr.get(i).a,fr.get(i).b,fr.get(i).c-fr.get(i).a,fr.get(i).d-fr.get(i).b);
                i++;
            }
            i =0;
            while(fc.size()>i){
                g.drawOval(fc.get(i).a,fc.get(i).b,fc.get(i).c-fc.get(i).a,fc.get(i).d-fc.get(i).b);
                i++;
            }
            i =0;
            while(fa.size()>i){
                g.drawLine(fa.get(i).a,fa.get(i).b,fa.get(i).c,fa.get(i).d);
                i++;
            }
            
            int k = pp.size();
//            System.out.println(" size of pencil points: "+pp.size());
            if(pp.isEmpty()==false){
                for(i=0;i<k;i++){
//                    System.out.println(pp.get(i).start+" to "+pp.get(i).end);
                    for(int j =pp.get(i).start;j<pp.get(i).end;j++){
//                        System.out.println(p.get(pp.get(i).start-1).x+","+p.get(pp.get(i).start-1).y+" to "+p.get(pp.get(i).end).x+","+p.get(pp.get(i).end).y);
                        g.drawLine(p.get(j-1).x,p.get(j-1).y,p.get(j).x,p.get(j).y);
                    }
                }
            }
            k= t.size();
            if(t.isEmpty()==false){
                for(int j=0;j<k;j++){
                    Font myfont =  new Font("Serif", Font.PLAIN, fontpt.get(j).f);
                    g.setFont(myfont);
                    g.drawString(input.get(j),t.get(j).x, t.get(j).y);
                }
            }
            k = pe.size();
//            System.out.println(" size of pencil points: "+pp.size());
            if(pe.isEmpty()==false){
                for(i=0;i<k;i++){
//                    System.out.println(pe.get(i).start+" to "+pe.get(i).end);
                    for(int j =pe.get(i).start;j<pe.get(i).end;j++){
                        g.setColor(Color.white);
//                        System.out.println(p.get(pp.get(i).start-1).x+","+p.get(pp.get(i).start-1).y+" to "+p.get(pp.get(i).end).x+","+p.get(pp.get(i).end).y);
                        g.fillOval(er.get(j-1).x,er.get(j-1).y,10,10);
                    }
                }
            }
            i =0;
            
            
            
        }
        else {
            super.paint(g);
            
        }
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Draw");
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        setPreferredSize(new java.awt.Dimension(1080, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 981, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 626, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(draw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(draw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(draw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(draw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new draw().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseDragged(MouseEvent e) {
             if(shape==1){
                 if(r.size()>0){
                rectangle = new points();
                rectangle.x=e.getX();
                rectangle.y=e.getY();
                //System.out.println(rectangle.x+" "+rectangle.y);
                r.add(rectangle);
                 }
                if(r.size()>3)
                repaint();
            }
             if(shape==2){
                 if(c.size()>0){
                circle = new points();
                circle.x=e.getX();
                circle.y=e.getY();
                //System.out.println(rectangle.x+" "+rectangle.y);
                c.add(circle);
                 }
                if(c.size()>3)
                repaint();
            }
             if(shape==3){
                 if(a.size()>0){
                arrow = new points();
                arrow.x=e.getX();
                arrow.y=e.getY();
                //System.out.println(rectangle.x+" "+rectangle.y);
                a.add(arrow);
                 }
                if(a.size()>3)
                repaint();
            }
             if(shape==4){
                 if(p.size()>0){
                pencil = new points();
                pencil.x=e.getX();
                pencil.y=e.getY();
//                System.out.println(pencil.x+" "+pencil.y);
                p.add(pencil);
                repaint();
                }
            }
             if(shape==5){
                 if(er.size()>0){
                eraser = new points();
                eraser.x=e.getX();
                eraser.y=e.getY();
//                System.out.println(pencil.x+" "+pencil.y);
                er.add(eraser);
                repaint();
                }
            }
    }
    public void mouseMoved(MouseEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
       if(shape==1){
            rectangle = new points();
            rectangle.x=e.getX();
            rectangle.y=e.getY();
            r_initx=e.getX();
            r_inity=e.getY();
//            System.out.println(r_initx+" :"+r_inity);
            r.add(rectangle);
            repaint();
        }
       if(shape==2){
            circle = new points();
            circle.x=e.getX();
            circle.y=e.getY();
            c_initx=e.getX();
            c_inity=e.getY();
//            System.out.println(c_initx+" :"+c_inity);
            c.add(circle);
            repaint();
        }
       if(shape==3){
            arrow = new points();
            arrow.x=e.getX();
            arrow.y=e.getY();
            a_initx=e.getX();
            a_inity=e.getY();
//            System.out.println(a_initx+" :"+a_inity);
            a.add(arrow);
            repaint();
        }
       if(shape==4){
            pencil = new points();
            pencil.x=e.getX();
            pencil.y=e.getY();
            p_initx=e.getX();
            p_inity=e.getY();
//            System.out.println(p_initx+" :"+p_inity);
            p.add(pencil);
            point_count pc = new point_count();
            pc.start=p.size();
            pp.add(pc);
//            System.out.println("current pp Size: "+pp.size());
//            System.out.println("Starting size of p for pencil: "+pp.get(pp.size()-1).start);
            
        }
       if(shape==5){
            eraser = new points();
            eraser.x=e.getX();
            eraser.y=e.getY();
            e_initx=e.getX();
            e_inity=e.getY();
//            System.out.println(p_initx+" :"+p_inity);
            er.add(eraser);
            point_count pc = new point_count();
            pc.start=er.size();
            pe.add(pc);
//            System.out.println("current pp Size: "+pp.size());
//            System.out.println("Starting size of p for pencil: "+pp.get(pp.size()-1).start);
            
       }
       if(shape==6){
           int x1=e.getX();
          int y1=e.getY();
          String userInput= JOptionPane.showInputDialog(rootPane,"ENTER TEXT");
          String userfont= JOptionPane.showInputDialog(rootPane,"ENTER FONT SIZE");
        //Scanner in=new Scanner(System.in);
        //String s=in.next();
        boolean flag = true;
        font obj1 = new font();
        int ft = 0;
           try {
                ft= Integer.parseInt(userfont);
           } catch (Exception ex) {
              JOptionPane.showMessageDialog(rootPane,"ONLY NUMERIC VALUE ALLOWED");
              flag=false;
           }
           if (flag){
        input.add(userInput);
        points obj = new points();
        obj.x=x1;
        obj.y=y1;
        t.add(obj);
        obj1.f=ft;
        fontpt.add(obj1);
        repaint();
           }
       }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(shape==1){
            r_finalx=e.getX();
            r_finaly=e.getY();
            finalpts obj = new finalpts();
            obj.a=r_initx;
            obj.b=r_inity;
            obj.c=r_finalx;
            obj.d=r_finaly;
            System.out.println(obj.a+" "+obj.b+" "+obj.c+" "+obj.d);
            fr.add(obj);
            update_draw();
        }
        if(shape==2){
            c_finalx=e.getX();
            c_finaly=e.getY();
            finalpts obj = new finalpts();
            obj.a=c_initx;
            obj.b=c_inity;
            obj.c=c_finalx;
            obj.d=c_finaly;
            System.out.println(obj.a+" "+obj.b+" "+obj.c+" "+obj.d);
            fc.add(obj);
            update_draw();
        }
        if(shape==3){
            a_finalx=e.getX();
            a_finaly=e.getY();
            finalpts obj = new finalpts();
            obj.a=a_initx;
            obj.b=a_inity;
            obj.c=a_finalx;
            obj.d=a_finaly;
            System.out.println(obj.a+" "+obj.b+" "+obj.c+" "+obj.d);
            fa.add(obj);
            update_draw();
        }
        if(shape==4){
            p_finalx=e.getX();
            p_finaly=e.getY();
//            points obj = new points();
//            obj.x=p_initx;
//            obj.y=p_inity;
//            System.out.println(obj.x+" "+obj.y+" ");
//            fp.add(obj);
            pp.get(pp.size()-1).end=p.size();
//            System.out.println("ending size of p for pencil: "+pp.get(pp.size()-1).end);
//            System.out.println("current pp Size: "+pp.size());
//            System.out.println("ending size of p for pencil: "+pp.get(pp.size()-1).end);
            
            update_draw();
        }
        if(shape==5){
            e_finalx=e.getX();
            e_finaly=e.getY();
//            points obj = new points();
//            obj.x=p_initx;
//            obj.y=p_inity;
//            System.out.println(obj.x+" "+obj.y+" ");
//            fp.add(obj);
            pe.get(pe.size()-1).end=er.size();
//            System.out.println("ending size of p for pencil: "+pp.get(pp.size()-1).end);
//            System.out.println("current pp Size: "+pp.size());
//            System.out.println("ending size of p for pencil: "+pp.get(pp.size()-1).end);
            
            update_draw();
        }
        if (shape==6){
            update_draw();
        }
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    void update_draw(){
        try {
            
        setCursor(java.awt.Cursor.CROSSHAIR_CURSOR);
        setResizable(true);
        setSize(1101,720);
//        setSize(getSize().height+1,getSize().width+1);
//        setSize(getSize().height-1,getSize().width-1);
        setSize(1100,720);
        setResizable(false);
        shape=10;
        repaint();
//        System.out.println("updated");
        
        } catch (Exception e) {
        }
    }
    
    
    void orig_area(){
        setSize(1100,720);
    }
    void open() throws IOException{
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("OPEN");
        fileChooser.setApproveButtonText("OPEN");
        int userSelection = fileChooser.showOpenDialog(this);
        fileChooser.setCurrentDirectory(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToOpen = fileChooser.getSelectedFile();
            System.out.println("Open as file: " + fileToOpen.getAbsolutePath());
            BufferedImage image = ImageIO.read(fileToOpen);
            JLabel label = new JLabel(new ImageIcon(image));
            label.setBounds(0,0,1100,720);
            getContentPane().add(label);
            getContentPane().setBackground(Color.white);
            label.setVisible(true);
            fileToSet = fileToOpen;
            background_set=true;
        }
    }
    void ask() {
        int j = JOptionPane.showConfirmDialog(this,"You will lose your current progress. continue anyway? " ,"confirmation dialog",JOptionPane.YES_NO_OPTION);
        if(j==JOptionPane.YES_OPTION){
            fa.clear();
            fr.clear();
            fc.clear();
            pp.clear();
            pe.clear();
            update_draw();
            try {
                open();
            } catch (IOException ex) {
                Logger.getLogger(draw.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    void save() throws AWTException, IOException{
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("SAVE as png format");   

        int userSelection = fileChooser.showSaveDialog(this);
        fileChooser.setCurrentDirectory(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            System.out.println("Save as file: " + fileToSave.getAbsolutePath());
            Robot robot = new Robot();
//            File obj = new File("C:\\Users\\Public\\imageTest.png");
            BufferedImage bi=robot.createScreenCapture(new Rectangle(3,27,1094,689));
            ImageIO.write(bi, "png", fileToSave);
        }
        
    
    }
    void eraser_cursor(){
        setCursor(java.awt.Cursor.DEFAULT_CURSOR);
    }
public class tools extends javax.swing.JFrame {

    /**
     * Creates new form tools
     */
    public tools() {
        initComponents();
        setVisible(true);
        setResizable(false);
        setBounds(1105,0,180,720);
        ts_updating th = new ts_updating();
        th.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        brect = new javax.swing.JButton();
        barrow = new javax.swing.JButton();
        bdb = new javax.swing.JButton();
        bcircle = new javax.swing.JButton();
        bpencil = new javax.swing.JButton();
        bat = new javax.swing.JButton();
        beraser = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        ts = new javax.swing.JLabel();
        ur = new javax.swing.JButton();
        ua = new javax.swing.JButton();
        ud = new javax.swing.JButton();
        uc = new javax.swing.JButton();
        up = new javax.swing.JButton();
        ut = new javax.swing.JButton();
        ue = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        open = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        brect.setText("rect");
        brect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brectActionPerformed(evt);
            }
        });

        barrow.setText("arrow");
        barrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barrowActionPerformed(evt);
            }
        });

        bdb.setText("DB");
        bdb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdbActionPerformed(evt);
            }
        });

        bcircle.setText("circle");
        bcircle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcircleActionPerformed(evt);
            }
        });

        bpencil.setText("pencil");
        bpencil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bpencilActionPerformed(evt);
            }
        });

        bat.setText("add text");
        bat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batActionPerformed(evt);
            }
        });

        beraser.setText("eraser");
        beraser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beraserActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tool Selected");

        ts.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ts.setText("none");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(bpencil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bcircle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bdb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(barrow, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                .addComponent(beraser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(brect, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(bat, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(brect)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barrow)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bcircle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bpencil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(beraser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ts, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ur.setText("UR");
        ur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urActionPerformed(evt);
            }
        });

        ua.setText("UA");
        ua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uaActionPerformed(evt);
            }
        });

        ud.setText("UD");
        ud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                udActionPerformed(evt);
            }
        });

        uc.setText("UC");
        uc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ucActionPerformed(evt);
            }
        });

        up.setText("UP");
        up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upActionPerformed(evt);
            }
        });

        ut.setText("UT");
        ut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                utActionPerformed(evt);
            }
        });

        ue.setText("UE");
        ue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ueActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Zurich Cn BT", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PALETTE");

        save.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        save.setText("SAVE");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        open.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        open.setText("OPEN");
        open.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    openActionPerformed(evt);
                    
                } catch (Exception e) {
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(ud, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ur, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(uc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(up, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(ut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ue, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(open, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(save, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(open, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ur)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ud)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(uc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(up)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ue)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>                        

    private void brectActionPerformed(java.awt.event.ActionEvent evt) {                                      
        shape = 1;
    }                                     

    private void bcircleActionPerformed(java.awt.event.ActionEvent evt) {                                        
        shape=2;

    }                                       

    private void bdbActionPerformed(java.awt.event.ActionEvent evt) {                                    
        // TODO add your handling code here:
    }                                   

    private void barrowActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        shape=3;
    }                                      

    private void uaActionPerformed(java.awt.event.ActionEvent evt) {                                   
        fa.remove(fa.size()-1);
        update_draw();
    }                                  

    private void udActionPerformed(java.awt.event.ActionEvent evt) {                                   
        // TODO add your handling code here:
    }                                  
    
    private void bpencilActionPerformed(java.awt.event.ActionEvent evt) {   
        shape = 4;
        
        // TODO add your handling code here:
    }                                       

    private void beraserActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        shape=5;
        eraser_cursor();
    }                                       

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        try{
//            setVisible(false);
            
            save();
            
//            setVisible(true);
            orig_area();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }                                    

    private void openActionPerformed(java.awt.event.ActionEvent evt) throws IOException{
        ask();
        
    }                                    

    private void batActionPerformed(java.awt.event.ActionEvent evt) {                                    
        // TODO add your handling code here:
        shape=6;
//        text_frame obj = new text_frame();
        
    }                                   

    private void urActionPerformed(java.awt.event.ActionEvent evt) {                                   
        // TODO add your handling code here:
        fr.remove(fr.size()-1);
        update_draw();
    }                                  

    private void ucActionPerformed(java.awt.event.ActionEvent evt) {                                   
        // TODO add your handling code here:
        fc.remove(fc.size()-1);
        update_draw();
    }                                  

    private void upActionPerformed(java.awt.event.ActionEvent evt) {                                   
        pp.remove(pp.size()-1);
        update_draw();
    }                                  

    private void utActionPerformed(java.awt.event.ActionEvent evt) {                                   
        // TODO add your handling code here:
        t.remove(t.size()-1);
        input.remove(input.size()-1);
        fontpt.remove(fontpt.size()-1);
        update_draw();
        
    }                                  

    private void ueActionPerformed(java.awt.event.ActionEvent evt) {                                   
        // TODO add your handling code here:
        pe.remove(pe.size()-1);
        update_draw();
    }                                  

    /**
     * @param args the command line arguments
     */
     void  update_ts(){
        if(shape==10){
            ts.setText("none");
        }
        else if(shape==1){
            ts.setText("Rectangle");
        }
        else if(shape==2){
            ts.setText("Ellipse");
        }
        else if(shape==3){
            ts.setText("Arrow");
        }
        else if(shape==4){
            ts.setText("Pencil");
        }
        else if(shape==5){
            ts.setText("Database");
        }
        else if(shape==6){
            ts.setText("Text");
        }
        else if(shape==7){
            ts.setText("Eraser");
        }
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton barrow;
    private javax.swing.JButton bat;
    private javax.swing.JButton bcircle;
    private javax.swing.JButton bdb;
    private javax.swing.JButton beraser;
    private javax.swing.JButton bpencil;
    private javax.swing.JButton brect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton open;
    private javax.swing.JButton save;
    private javax.swing.JLabel ts;
    private javax.swing.JButton ua;
    private javax.swing.JButton uc;
    private javax.swing.JButton ud;
    private javax.swing.JButton ue;
    private javax.swing.JButton up;
    private javax.swing.JButton ur;
    private javax.swing.JButton ut;
    // End of variables declaration                   

      class ts_updating extends Thread{
        public void run() {
            try {while(true){
                sleep(500);
                update_ts();
            }
            } catch (Exception e) {
            }
            
        }
    }  
    }
    class text_frame extends javax.swing.JFrame {
        JTextField str;
        JButton set;

        public text_frame() throws HeadlessException {
            setVisible(true);
            str = new JTextField();
            set = new JButton("set");
            setLocation(20,20);
            setSize(120,40);
            str.setBounds(25,25, 90, 30);
            set.setBounds(125,25, 20, 30);
            add(str);
            add(set);
        }
        
                
    }
}