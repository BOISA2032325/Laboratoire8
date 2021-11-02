package sample;

import java.awt.*;
import java.util.Map;

public class DimensionFenetre {

     /*
        Pour faire ceci j'ai eu besoin du site suivant et comme je n'était pas sur que je devais mettre les sources j'ai
        décider de les mettre pour etre sur : https://askcodez.com/comment-faire-pour-redimensionner-automatiquement-les-fenetres-en-javafx-pour-differentes-resolutions.html
         */

    public int hauteur(){
        GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int height = graphicsDevice.getDisplayMode().getHeight();
        return height;
    }

    public int largeur(){
        GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = graphicsDevice.getDisplayMode().getWidth();
        return width;
    }


}
