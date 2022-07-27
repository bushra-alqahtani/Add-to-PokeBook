package com.codingdojo.mvc.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="pokebook")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 200 ,message="you must to write expense")
    private String expense;
    
    @NotNull
    @Size(min = 1, max = 200 ,message="you must to write vendor")
    private String vendor ;
    
    @NotNull
    @Min(100)
    private Integer amount;
    
    @NotNull
    @Size(min = 1, max = 80)
    private String deiscription;
    
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    
    
    
    public Book() {
    }
    public Book(String expense, String vendor, int amount, String deiscription) {
        this.expense = expense;
        this.vendor = vendor;
        this.amount = amount;
        this.deiscription = deiscription;
    }
    
    //getter and setter
	public Long getId() {
		return id;
	}
	
	public String getExpense() {
		return expense;
	}
	public void setExpense(String expense) {
		this.expense = expense;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getDeiscription() {
		return deiscription;
	}
	public void setDeiscription(String deiscription) {
		this.deiscription = deiscription;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	// other getters and setters removed for brevity
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}