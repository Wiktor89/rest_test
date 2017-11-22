CREATE TABLE units (
    id SERIAL PRIMARY KEY,
    units_distance VARCHAR(250),
    units_pressure VARCHAR(250),
    units_speed VARCHAR(250),
    units_temperature VARCHAR(250)
);

CREATE TABLE locations (
    id SERIAL PRIMARY KEY,
    loc_city VARCHAR(250),
    loc_country VARCHAR(250),
    loc_region VARCHAR(250)
);

CREATE TABLE winds (
    id SERIAL PRIMARY KEY,
    wind_chill INTEGER,
    wind_direction INTEGER,
    wind_speed INTEGER
);

CREATE TABLE atmospheres (
    id SERIAL PRIMARY KEY,
    atmo_humidity INTEGER,
    atmo_pressure REAL,
    atmo_rising INTEGER,
    atmo_visibility REAL
);

CREATE TABLE astronomy (
    id SERIAL PRIMARY KEY,
    astro_sunrise VARCHAR(250),
    astro_sunset VARCHAR(250)
);

CREATE TABLE images (
    id SERIAL PRIMARY KEY,
    image_title VARCHAR(250),
    image_width INTEGER,
    image_height INTEGER,
    image_link VARCHAR(250),
    image_url VARCHAR(250)
);

CREATE TABLE conditions (
    id SERIAL PRIMARY KEY,
    condition_code INTEGER,
    condition_date VARCHAR(250),
    condition_temp INTEGER,
    condition_text VARCHAR(250)
);

CREATE TABLE items (
    id SERIAL PRIMARY KEY,
    item_title VARCHAR(250),
    item_lat REAL,
    item_long REAL,
    item_link VARCHAR(250),
    item_desc VARCHAR(250),
    item_pub_date VARCHAR(250),
    item_condition INTEGER REFERENCES conditions ON DELETE RESTRICT
);

CREATE TABLE forecasts (
    id SERIAL PRIMARY KEY,
    forecast_date VARCHAR(250),
    forecast_day VARCHAR(10),
    forecast_high INTEGER,
    forecast_low INTEGER,
    forecast_text VARCHAR(250),
    forecast_item INTEGER REFERENCES items ON DELETE CASCADE
);

CREATE TABLE channels (
    id SERIAL PRIMARY KEY,
    channel_units INTEGER REFERENCES units ON DELETE RESTRICT,
    channel_title VARCHAR(250),
    channel_link VARCHAR(250),
    channel_desc VARCHAR(250),
    channel_lang VARCHAR(10),
    channel_last_build VARCHAR(250),
    channel_ttl INTEGER,
    channel_location INTEGER REFERENCES locations ON DELETE RESTRICT,
    channel_wind INTEGER REFERENCES winds ON DELETE RESTRICT,
    channel_atmosphere INTEGER REFERENCES atmospheres ON DELETE RESTRICT,
    channel_astronomy INTEGER REFERENCES astronomy ON DELETE RESTRICT,
    channel_image INTEGER REFERENCES images ON DELETE RESTRICT,
    channel_item INTEGER REFERENCES items ON DELETE RESTRICT
);

CREATE TABLE queries (
    id SERIAL PRIMARY KEY,
    query_count INTEGER,
    query_created VARCHAR(250),
    query_lang VARCHAR(10),
    query_channel INTEGER REFERENCES channels ON DELETE RESTRICT
);

CREATE UNIQUE INDEX query_created_ui ON queries(query_created);