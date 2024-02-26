package co.wedevx.digitalbank.automation.api.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserAPIModel {

        private int id;
        private String username;
        private boolean enabled;
        private boolean accountNonExpired;
        private boolean accountNonLocked;
        private boolean credentialsNonExpired;
        @JsonProperty("userProfile")
        private UserProfileAPIModel userProfile;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public boolean isAccountNonExpired() {
            return accountNonExpired;
        }

        public void setAccountNonExpired(boolean accountNonExpired) {
            this.accountNonExpired = accountNonExpired;
        }

        public boolean isAccountNonLocked() {
            return accountNonLocked;
        }

        public void setAccountNonLocked(boolean accountNonLocked) {
            this.accountNonLocked = accountNonLocked;
        }

        public boolean isCredentialsNonExpired() {
            return credentialsNonExpired;
        }

        public void setCredentialsNonExpired(boolean credentialsNonExpired) {
            this.credentialsNonExpired = credentialsNonExpired;
        }

        public UserProfileAPIModel getUserprofile() {
            return userProfile;
        }

        public void setUserprofile(UserProfileAPIModel userprofile) {
            this.userProfile = userprofile;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", username='" + username + '\'' +
                    ", enabled=" + enabled +
                    ", accountNonExpired=" + accountNonExpired +
                    ", accountNonLocked=" + accountNonLocked +
                    ", credentialsNonExpired=" + credentialsNonExpired +
                    ", userProfile=" + userProfile +
                    '}';
        }
    }

