package module3.builder;

/**
 * PRACTICE QUESTION: Builder Pattern
 *
 * Scenario: You are building a user profile system.
 *
 * Your goal:
 * 1. Create a `UserProfile` class with optional fields.
 * 2. Use a nested `Builder` to construct it.
 * 3. Required field: `username`
 * 4. Optional fields: `email`, `phone`, `address`, `age`
 * 5. Print the profile details in `main`.
 *
 * Hint:
 * Avoid creating a constructor with too many parameters.
 */

class UserProfile {
    private final String username; // required
    private final String email;    // optional
    private final String phone;    // optional
    private final String address;  // optional
    private final Integer age;     // optional

    private UserProfile(Builder builder) {
        this.username = builder.username;
        this.email = builder.email;
        this.phone = builder.phone;
        this.address = builder.address;
        this.age = builder.age;
    }

    public String getProfileDetails() {
        return "UserProfile[username=" + username + ", email=" + email + ", phone=" + phone + ", address=" + address + ", age=" + age + "]";
    }

    public static class Builder {
        private final String username; // required
        private String email;          // optional
        private String phone;          // optional
        private String address;        // optional
        private Integer age;           // optional

        public Builder(String username) {
            this.username = username;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setAge(Integer age) {
            this.age = age;
            return this;
        }

        public UserProfile build() {
            return new UserProfile(this);
        }
    }
}

public class BuilderPractice {
    public static void main(String[] args) {
        System.out.println("--- Builder Practice ---");
        
        UserProfile user1 = new UserProfile.Builder("john_doe")
                .setEmail("john.doe@example.com")
                .setPhone("123-456-7890")
                .setAddress("123 Main St")
                .setAge(30)
                .build();

        System.out.println(user1.getProfileDetails());

        UserProfile user2 = new UserProfile.Builder("jane_smith")
                .setEmail("jane.smith@example.com")
                .build();

        System.out.println(user2.getProfileDetails());


        System.out.println("Complete the TODOs to practice Builder.");
    }
}
