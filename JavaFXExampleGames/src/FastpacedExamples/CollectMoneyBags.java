package FastpacedExamples;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Iterator;

// Collect the Money Bags!
public class CollectMoneyBags extends Application
{
    public static void main(String[] args) 
    {
        launch(args);
    }

    @Override
    public void start(Stage theStage) 
    {
        theStage.setTitle( "Collect the Money Bags!" );

        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );

        Canvas canvas = new Canvas( 800, 600 );
        root.getChildren().add( canvas );
        root.setCursor(Cursor.NONE);

        ArrayList<String> input = new ArrayList<>();

        theScene.setOnKeyPressed(
                e -> {
                    String code = e.getCode().toString();
                    if ( !input.contains(code) )
                        input.add( code );
                });

        theScene.setOnKeyReleased(
                e -> {
                    String code = e.getCode().toString();
                    input.remove( code );
                });

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Font theFont = Font.font( "Helvetica", FontWeight.BOLD, 24 );
        gc.setFont( theFont );
        gc.setFill( Color.GREEN );
        gc.setStroke( Color.BLACK );
        gc.setLineWidth(1);
        
        Sprite briefcase = new Sprite();
        briefcase.setImage("briefcase.png");
        briefcase.setPosition(200, 0);
        theScene.setOnMouseMoved(arg0 -> {
            if(arg0.getEventType() == MouseEvent.MOUSE_MOVED){
                handle(arg0.getX(),arg0.getY(), briefcase);
            }
        });
        ArrayList<Sprite> moneybagList = new ArrayList<Sprite>();
        
        for (int i = 0; i < 15; i++)
        {
            Sprite moneybag = new Sprite();
            moneybag.setImage("moneybag.png");
            double px = 350 * Math.random() + 50;
            double py = 350 * Math.random() + 50;          
            moneybag.setPosition(px,py);
            moneybagList.add( moneybag );
        }
        
        LongValue lastNanoTime = new LongValue( System.nanoTime() );

        IntValue score = new IntValue(0);

        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                // calculate time since last update.
                double elapsedTime = (currentNanoTime - lastNanoTime.value) / 1000000000.0;
                lastNanoTime.value = currentNanoTime;
                
                // game logic
                briefcase.setVelocity(0,0);
                if (input.contains("LEFT"))
                    briefcase.addVelocity(-10,0);
                if (input.contains("RIGHT"))
                    briefcase.addVelocity(10,0);
                if (input.contains("UP"))
                    briefcase.addVelocity(0,-10);
                if (input.contains("DOWN"))
                    briefcase.addVelocity(0,10);
                    
                briefcase.update(elapsedTime);
                
                // collision detection

                int removedItems = 0;
                Iterator<Sprite> moneybagIter = moneybagList.iterator();
                while ( moneybagIter.hasNext() )
                {

                    Sprite moneybag = moneybagIter.next();
                    moneybag.setPosition(moneybag.getPositionX(), moneybag.getPositionY() + 10);
                    if ( briefcase.intersects(moneybag) || moneybag.getPositionY() > 512 )
                    {
                        removedItems++;
                        moneybagIter.remove();
                        if (moneybag.getPositionY() < 512){
                            score.value++;
                        }
                    }
                }

                while (removedItems > 0){
                    Sprite moneybag = new Sprite();
                    moneybag.setImage("moneybag.png");
                    double px = 750 * Math.random();
                    double py = 0;
                    moneybag.setPosition(px,py);
                    moneybagList.add( moneybag );
                    removedItems--;
                }
                
                // render
                
                gc.clearRect(0, 0, 800,600);
                briefcase.render( gc );
                
                for (Sprite moneybag : moneybagList )
                    moneybag.render( gc );

                String pointsText = "Cash: $" + (100 * score.value);
                gc.fillText( pointsText, 360, 36 );
                gc.strokeText( pointsText, 360, 36 );
            }
        }.start();

        theStage.show();
    }

    private void handle(double x, double y, Sprite sprite){
        sprite.setPosition(x - 20,y - 20);
    }
}