package Domain;

import java.sql.Timestamp;

/**
 * Created by esha on 2/20/17.
 */
public class Order {
    public Order() {

    }

        private int orderId;
        private int userId;
        private Timestamp timestamp;
        private String status;

        public Order(int orderId, int userId, Timestamp timestamp, String status) {
            this.orderId = orderId;
            this.userId = userId;
            this.timestamp=timestamp;
            this.status = status;
        }

        public Order(int userId, Timestamp timestamp, String status) {
            this.userId = userId;
            this.timestamp=timestamp;
            this.status = status;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public int getuserid() {
            return  userId;
        }
        public String getName(){
            return getName();
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public Timestamp getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Timestamp timestamp) {
            this.timestamp = timestamp;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "orderId=" + orderId +
                    ", userId=" + userId +
                    ", createdDate=" + timestamp +
                    ", status='" + status + '\'' +
                    '}';
        }
    }



