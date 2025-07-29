package com.dz3_1.mvc;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class FileStorage implements FileWritable{
    private String fileName;
    private File file;
    private RowCountable rowCounter;

    public FileStorage() {}

    public FileStorage(String fileName, RowCountable rowCounter) {
        this.file = createFile(fileName);
        this.fileName = fileName;
        this.rowCounter = rowCounter;
    }

    @Override
    public boolean IsWriteOk(String text) {
        File f = this.file;
        FileWriter fw = null;
        try {
            if (this.getSavedRowCount() >0) {
                fw = new FileWriter(f,true); // append next row
            } else {
                fw = new FileWriter(f); // new app run - new data in file
            }
//            System.out.println("fw opened");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        try {
            fw.write(text + " \n");
            System.out.println("row: " + text + " was written to " + f.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                fw.close();
//                System.out.println("fw closed");
            } catch (IOException e) {
                System.err.println("Error closing FileWriter: " + e.getMessage());
            }
        }
        this.rowCounter.increment();
        return true;
    }

    public ArrayList<String> getAllRows() {
        ArrayList<String> rows = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(this.file));
            String line = "";
            while ((line = br.readLine()) != null) {
                rows.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error opening File: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (br != null) {
              try {
                  br.close();
              } catch (IOException e) {
                  System.err.println("Error closing BufferedReader: " + e.getMessage());
                  e.printStackTrace();
              }
            }
        }
        System.out.println("getAllRows(): " + rows);
        return rows;
    }

    public Integer getSavedRowCount() {
        return this.rowCounter.getValue();
    }

    private File createFile(String fileName ) {
        File f = new File(fileName);
//        System.out.println("File: " + f.getName());
        File dir = f.getParentFile();
//        System.out.println("Directory: " + dir.getName());

        if (!dir.exists()) {
            System.out.println("Directory " + dir.getName() + " not found, try create...");
            if(dir.mkdirs()) {
                System.out.println("Directory " + dir.getName() + " created successfully");
            } else {
                System.out.println("Something wrong! Directory " + dir.getName() + " not created");
            }
        } else {
            System.out.println("Directory " + dir.getName() + " already exists");
        }

        if(!f.exists()) {
            System.out.println("File not found, try create...");
            try {
                if (f.createNewFile()){
                    System.out.println("File " + f.getName() + " created successfully");
                }
            } catch (IOException e) {
                System.err.println("Error creating file " + f.getName() + ": " + e.getMessage());
            }
        } else {
            System.out.println("File " + f.getName() + " already exists");
        }
        return f;
    }

    @Override
    public String toString() {
        return "FileStorage{" +
                "fileName='" + fileName + '\'' +
                ", file=" + file +
                '}';
    }

    public String getFileName() {
        return fileName;
    }
}
