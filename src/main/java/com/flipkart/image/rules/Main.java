package com.flipkart.image.rules;

import org.im4java.core.IM4JavaException;

import java.io.IOException;

/**
 * Created by shivendra.singh on 09/07/14.
 */
public class Main {
    public static void main(String[] args) {
        try {
            new ImageRuleColor().validate("/Users/shivendra.singh/Downloads/ckc3130725brown-peter-england-m-400x400-imadxnh4pmutxugc.jpeg","brown");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IM4JavaException e) {
            e.printStackTrace();
        }
    }

}
