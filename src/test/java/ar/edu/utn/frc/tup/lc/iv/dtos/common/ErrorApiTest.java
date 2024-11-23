package ar.edu.utn.frc.tup.lc.iv.dtos.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorApiTest {
    @Test
    void testErrorApiConstructorAndGetters() {
        // Arrange
        String expectedTimestamp = "2024-10-05T10:00:00Z";
        Integer expectedStatus = 404;
        String expectedError = "Not Found";
        String expectedMessage = "The requested resource was not found.";

        // Act
        ErrorApi errorApi = new ErrorApi(expectedTimestamp, expectedStatus, expectedError, expectedMessage);

        // Assert
        assertEquals(expectedTimestamp, errorApi.getTimestamp());
        assertEquals(expectedStatus, errorApi.getStatus());
        assertEquals(expectedError, errorApi.getError());
        assertEquals(expectedMessage, errorApi.getMessage());
    }

    @Test
    void testErrorApiSetters() {
        // Arrange
        ErrorApi errorApi = new ErrorApi();
        String expectedTimestamp = "2024-10-05T10:00:00Z";
        Integer expectedStatus = 500;
        String expectedError = "Internal Server Error";
        String expectedMessage = "An unexpected error occurred.";

        // Act
        errorApi.setTimestamp(expectedTimestamp);
        errorApi.setStatus(expectedStatus);
        errorApi.setError(expectedError);
        errorApi.setMessage(expectedMessage);

        // Assert
        assertEquals(expectedTimestamp, errorApi.getTimestamp());
        assertEquals(expectedStatus, errorApi.getStatus());
        assertEquals(expectedError, errorApi.getError());
        assertEquals(expectedMessage, errorApi.getMessage());
    }

    @Test
    void testErrorApiBuilder() {
        // Arrange
        String expectedTimestamp = "2024-10-05T10:00:00Z";
        Integer expectedStatus = 400;
        String expectedError = "Bad Request";
        String expectedMessage = "Invalid request format.";

        // Act
        ErrorApi errorApi = ErrorApi.builder()
                .timestamp(expectedTimestamp)
                .status(expectedStatus)
                .error(expectedError)
                .message(expectedMessage)
                .build();

        // Assert
        assertEquals(expectedTimestamp, errorApi.getTimestamp());
        assertEquals(expectedStatus, errorApi.getStatus());
        assertEquals(expectedError, errorApi.getError());
        assertEquals(expectedMessage, errorApi.getMessage());
    }

}