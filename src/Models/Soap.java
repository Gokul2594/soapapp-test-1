package Models;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Arrays;

public class Soap {
    private String brand;
    private String intendedUse;
    private int volume;
    private Image soapImage;

    public Soap(String brand, String intendedUse, int volume) {
        setBrand(brand);
        setIntendedUse(intendedUse);
        setVolume(volume);
        setSoapImage(new Image(getImageFileName()));
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if(brand.isEmpty())
            throw new IllegalArgumentException("Brand name cannot be empty.");
        else
            this.brand = brand;
    }

    public String getIntendedUse() {
        return intendedUse;
    }

    public void setIntendedUse(String intendedUse) {
        ArrayList<String> validIntendedUse = new ArrayList<>();
        validIntendedUse.add("dish");
        validIntendedUse.add("hand");
        validIntendedUse.add("floor");
        if(validIntendedUse.contains(intendedUse.toLowerCase()))
            this.intendedUse = intendedUse;
        else
            throw new IllegalArgumentException("The intended use should be Hand, dish or Floor ");
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if(volume > 0 && volume <= 10000)
            this.volume = volume;
        else
            throw new IllegalArgumentException("Volume should be greater than 0 and less than or equal to 10000 ");
    }

    public Image getSoapImage() {
        return soapImage;
    }

    public void setSoapImage(Image soapImage) {
        this.soapImage = soapImage;
    }

    public String getImageFileName(){
        return String.format("images/%s.jpg", getBrand().toLowerCase());
    }

    public String toString(){
        return String.format("%s   (%d ml)", getBrand(), getVolume());
    }
}

