import javafx.scene.shape.Circle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BallBounce implements ActionListener {


    final int HEIGHT=800,WIDTH=1000;

    static BallBounce ballBounce;

    int watch;

    int ballXDir;
    int ballYDir;

    Paint p;

    public Circle ball;

    BallBounce()
    {
        Timer timer=new Timer(5,this);

        JFrame jframe=new JFrame("Bounce");

        p=new Paint();

        ball= new Circle(WIDTH/2-25,HEIGHT/2-25,50);

        watch=1;

        jframe.setSize(WIDTH,HEIGHT);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setBackground(Color.BLACK);
        jframe.setResizable(false);
        jframe.setVisible(true);
        jframe.add(p);

        ballXDir=-1;
        ballYDir=-1;

        timer.start();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        p.repaint();
    }

    public void ballMovement() {
       if(ballXDir==-1 && ballYDir==-1)
       {
           ballXDir=1;
           ballYDir=2;
       }
       else if(ballXDir==1 && ballYDir==1)
       {
           System.out.println("1");
           if(ball.getCenterX()+ball.getRadius()>0 && ball.getCenterY() +ball.getRadius()>0)
           {
               ball.setCenterX(ball.getCenterX()-1);
               ball.setCenterY(ball.getCenterY()-1);
           }
           else
           {
               if(ball.getCenterX()+ball.getRadius()==0)
               {
                   ballXDir=2;
               }
               else
               {
                   ballYDir=2;
               }
           }
       }
       else if(ballXDir==1 && ballYDir==2)
       {
           System.out.println("2");
           if(ball.getCenterX()+ball.getRadius()>0 && ball.getCenterY() +ball.getRadius()<HEIGHT)
           {
               ball.setCenterX(ball.getCenterX()-1);
               ball.setCenterY(ball.getCenterY()+1);
           }
           else
           {
               if(ball.getCenterX()+ball.getRadius()==0)
               {
                   ballXDir=2;
               }
               else
               {
                   ballYDir=1;
               }
           }
       }
       else if(ballXDir==2 && ballYDir==1)
       {
           System.out.println("3");
           if(ball.getCenterX()+ball.getRadius()<WIDTH && ball.getCenterY() +ball.getRadius()>0)
           {
               ball.setCenterX(ball.getCenterX()+1);
               ball.setCenterY(ball.getCenterY()-1);
           }
           else
           {
               if(ball.getCenterX()+ball.getRadius()==WIDTH)
               {
                   ballXDir=1;
               }
               else
               {
                   ballYDir=2;
               }
           }

       }
       else if(ballXDir==2 && ballYDir==2)
       {
           System.out.println("4");
           if(ball.getCenterX() +ball.getRadius()<WIDTH && ball.getCenterY()+ball.getRadius()<HEIGHT)
           {
               ball.setCenterX(ball.getCenterX()+1);
               ball.setCenterY(ball.getCenterY()+1);
           }
           else
           {
               if(ball.getCenterX()+ball.getRadius()==WIDTH && ball.getCenterY() +ball.getRadius()==HEIGHT)
               {
                   ballXDir=1;
                   ballYDir=1;
               }
               else if(ball.getCenterX()+ball.getRadius()==WIDTH)
               {
                   ballXDir=1;
               }
               else if(ball.getCenterY() +ball.getRadius()==HEIGHT)
               {
                   ballYDir=1;
               }
           }

       }

    }

    public void repaint(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillRect(0,0,WIDTH,HEIGHT);

        g.setColor(Color.yellow);
        g.fillOval((int)ball.getCenterX(),(int)ball.getCenterY(),(int)ball.getRadius(),(int)ball.getRadius());

        ballMovement();
    }


    public static void main(String[] args)
    {
        ballBounce=new BallBounce();
    }

}
