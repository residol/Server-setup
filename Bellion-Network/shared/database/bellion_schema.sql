-- Bellion Network SQL Schema
CREATE DATABASE IF NOT EXISTS bellion;
USE bellion;

-- Utenti
CREATE TABLE IF NOT EXISTS users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  uuid VARCHAR(36) NOT NULL UNIQUE,
  username VARCHAR(32) NOT NULL,
  rank VARCHAR(32) DEFAULT 'Guest',
  joined_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  last_login DATETIME DEFAULT CURRENT_TIMESTAMP,
  coins BIGINT DEFAULT 0,
  gems BIGINT DEFAULT 0,
  honor_points BIGINT DEFAULT 0,
  build_tokens BIGINT DEFAULT 0
);

-- Statistiche globali
CREATE TABLE IF NOT EXISTS global_stats (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  stat_key VARCHAR(64),
  stat_value BIGINT DEFAULT 0,
  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- Statistiche per gamemode
CREATE TABLE IF NOT EXISTS gamemode_stats (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  gamemode VARCHAR(32),
  stat_key VARCHAR(64),
  stat_value BIGINT DEFAULT 0,
  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- Ranking/ELO
CREATE TABLE IF NOT EXISTS rankings (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  gamemode VARCHAR(32),
  elo INT DEFAULT 1000,
  season INT DEFAULT 1,
  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- Permessi custom
CREATE TABLE IF NOT EXISTS permissions (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  permission VARCHAR(64),
  value BOOLEAN DEFAULT TRUE,
  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- Achievements
CREATE TABLE IF NOT EXISTS achievements (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  achievement_key VARCHAR(64),
  achieved_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- Crates
CREATE TABLE IF NOT EXISTS crates (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  crate_type VARCHAR(32),
  received_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- Logs
CREATE TABLE IF NOT EXISTS logs (
  id INT AUTO_INCREMENT PRIMARY KEY,
  log_type VARCHAR(32),
  message TEXT,
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);