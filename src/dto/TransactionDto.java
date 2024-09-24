package dto;

import java.math.BigDecimal;
import java.sql.Date;

public class TransactionDto {

    private Integer transaction_id;
    private String book_id;
    private String member_id;
    private Date borrow_date;
    private Date due_date;
    private Date  return_date;
    private BigDecimal fine;

    
    public TransactionDto(Integer transaction_id, String book_id, String member_id, Date borrow_date, Date due_date,
            Date return_date, BigDecimal fine) {
        this.transaction_id = transaction_id;
        this.book_id = book_id;
        this.member_id = member_id;
        this.borrow_date = borrow_date;
        this.due_date = due_date;
        this.return_date = return_date;
        this.fine = fine;
    }


    public Integer getTransaction_id() {
        return transaction_id;
    }


    public void setTransaction_id(Integer transaction_id) {
        this.transaction_id = transaction_id;
    }


    public String getBook_id() {
        return book_id;
    }


    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }


    public String getMember_id() {
        return member_id;
    }


    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }


    public Date getBorrow_date() {
        return borrow_date;
    }


    public void setBorrow_date(Date borrow_date) {
        this.borrow_date = borrow_date;
    }


    public Date getDue_date() {
        return due_date;
    }


    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }


    public Date getReturn_date() {
        return return_date;
    }


    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }


    public BigDecimal getFine() {
        return fine;
    }


    public void setFine(BigDecimal fine) {
        this.fine = fine;
    }


    @Override
    public String toString() {
        return "TransactionDto [transaction_id=" + transaction_id + ", book_id=" + book_id + ", member_id=" + member_id
                + ", borrow_date=" + borrow_date + ", due_date=" + due_date + ", return_date=" + return_date + ", fine="
                + fine + "]";
    } 

    

}
