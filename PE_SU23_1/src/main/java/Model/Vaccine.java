
package Model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Vaccine implements Serializable{
   private String name;
   private String code;
   private int quantity;
   private Date expirationDate;
   private double price;
   private Date lastInjectedDate;

    public Vaccine(String code, String name, int quantity, Date expirationDate, double price, Date lastInjectedDate) {
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
        this.price = price;
        this.lastInjectedDate = lastInjectedDate;
    }
    public Vaccine(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getLastInjectedDate() {
        return lastInjectedDate;
    }

    public void setLastInjectedDate(Date lastInjectedDate) {
        this.lastInjectedDate = lastInjectedDate;
    }

    @Override
    public String toString() {
        return "Vaccine{" + "code=" + code + ", name=" + name + ", quantity=" + quantity + ", expirationDate=" + expirationDate + ", price=" + price + ", lastInjectedDate=" + lastInjectedDate + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    
    public boolean equals1(Object obj) {
        Vaccine that =(Vaccine) obj;
       return this.code.equalsIgnoreCase(that.code) ;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vaccine other = (Vaccine) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        if (!Objects.equals(this.expirationDate, other.expirationDate)) {
            return false;
        }
        return Objects.equals(this.lastInjectedDate, other.lastInjectedDate);
    }
   
}
