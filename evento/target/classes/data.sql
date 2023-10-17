INSERT INTO user_model(email, name, password, user_role)
VALUES ('admin@ifpb.com', 'Admin', '$2a$10$.piguPPbo5EtrcYe3lD8QeI59.Q1HfJk6V6Zu/zo82P.ZZ4Bi2.4i', 'ADMIN')
    ON CONFLICT (email) DO NOTHING;

