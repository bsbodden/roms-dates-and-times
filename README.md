# Working with Date/Time Types in Redis OM Spring

This project is a Spring Boot application that demonstrates the use of Redis OM Spring to store and query a collection of temporal (date and time) data types in a Redis database. The application provides a REST API to perform various date and time range searches on stored `Temporal` objects.

## Project Structure

- **Model**: Defines a `Temporal` class with various date and time types (`LocalDate`, `LocalDateTime`, `OffsetDateTime`, `Date`, `Instant`, and `YearMonth`).
- **Repository**: Implements a `TemporalRepository` interface with range query methods for each date/time type.
- **Controller**: Exposes API endpoints for range queries on the `Temporal` data.

## Getting Started

1. **Clone the repository**:
   ```bash
   git clone https://github.com/bsbodden/roms-dates-and-times.git
   cd redis-temporal-api
   ```

2. **Start Redis**:
   Make sure you have Redis running. You can start Redis with Docker:
   ```bash
   docker run -p 6379:6379 redis/redis-stack-server:latest
   ```

3. **Run the application**:
   ```bash
   ./mvnw spring-boot:run
   ```

   The application will load test data into Redis on startup, creating 10 `Temporal` objects with date/time values starting from December 31, 1999, spaced one year apart.

## API Endpoints

Each endpoint performs a specific date or time range query on `Temporal` objects. The expected results for each endpoint are based on the loaded data.

### LocalDate Queries

- **`GET /temporal/localDateBetween`**
    - Retrieves `Temporal` objects with `localDate` between `2000-01-01` and `2004-01-01`.
    - **Expected IDs**: `temporal_1` to `temporal_4`.

- **`GET /temporal/localDateLessThan`**
    - Retrieves `Temporal` objects with `localDate` before `2005-01-01`.
    - **Expected IDs**: `temporal_0` to `temporal_5`.

- **`GET /temporal/localDateGreaterThanEqual`**
    - Retrieves `Temporal` objects with `localDate` on or after `2005-01-01`.
    - **Expected IDs**: `temporal_6` to `temporal_9`.

- **`GET /temporal/localDateLessThanEqual`**
    - Retrieves `Temporal` objects with `localDate` on or before `2004-01-01`.
    - **Expected IDs**: `temporal_0` to `temporal_4`.

### LocalDateTime Queries

- **`GET /temporal/localDateTimeBetween`**
    - Retrieves `Temporal` objects with `localDateTime` between `2000-01-01T00:00:00` and `2004-01-01T00:00:00`.
    - **Expected IDs**: `temporal_1` to `temporal_4`.

- **`GET /temporal/localDateTimeLessThan`**
    - Retrieves `Temporal` objects with `localDateTime` before `2005-01-01T00:00:00`.
    - **Expected IDs**: `temporal_0` to `temporal_5`.

- **`GET /temporal/localDateTimeGreaterThanEqual`**
    - Retrieves `Temporal` objects with `localDateTime` on or after `2005-01-01T00:00:00`.
    - **Expected IDs**: `temporal_6` to `temporal_9`.

- **`GET /temporal/localDateTimeLessThanEqual`**
    - Retrieves `Temporal` objects with `localDateTime` on or before `2004-01-01T00:00:00`.
    - **Expected IDs**: `temporal_0` to `temporal_4`.

### OffsetDateTime Queries

- **`GET /temporal/localOffsetDateTimeBetween`**
    - Retrieves `Temporal` objects with `localOffsetDateTime` between `2000-01-01T00:00:00Z` and `2004-01-01T00:00:00Z`.
    - **Expected IDs**: `temporal_1` to `temporal_4`.

### Date Queries

- **`GET /temporal/dateBetween`**
    - Retrieves `Temporal` objects with `date` between `2000-01-01T00:00:00Z` and `2004-01-01T00:00:00Z`.
    - **Expected IDs**: `temporal_1` to `temporal_4`.

### Instant Queries

- **`GET /temporal/instantBetween`**
    - Retrieves `Temporal` objects with `instant` between `2000-01-01T00:00:00Z` and `2004-01-01T00:00:00Z`.
    - **Expected IDs**: `temporal_1` to `temporal_4`.

### YearMonth Queries

- **`GET /temporal/yearMonthBetween`**
    - Retrieves `Temporal` objects with `yearMonth` between `2000-01` and `2004-01`.
    - **Expected IDs**: `temporal_1` to `temporal_4`.

### EntityStream Query Example

- **`GET /temporal/localDateBetweenStream`**
    - Uses the Redis OM Spring `EntityStream` API to retrieve `Temporal` objects with `localDate` between `2000-01-01` and `2004-01-01`.
    - **Expected IDs**: `temporal_1` to `temporal_4`.

## Technologies Used

- **Java 17**
- **Spring Boot** for application setup and REST API creation.
- **Redis OM Spring** for Redis document management and range queries.
- **Redis** as the database.
- **Docker** (optional) for running Redis.