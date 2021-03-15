package com.iSpringboot.java8;

import java.io.File;
import java.io.FileFilter;

/**
 * @author GuoBenben
 * @version 2020/07/13/ 9:07
 */
public class MainClass
{

    public static void main(String[] args)
    {
        File file = new File("");

        /**
         * old story
         */
        File[] hiddenFiles = file.listFiles(new FileFilter()
        {
            @Override
            public boolean accept(File file)
            {
                System.out.println("~~~~~~~~~~~~~~");
                return file.isHidden();
            }
        });

        /**
         * new story
         */
        hiddenFiles = file.listFiles(File::isHidden);

    }
}
