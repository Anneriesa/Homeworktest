import org.example.IElement;
import org.example.Portfolio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PortfolioTest {

    // Mock IElement implementation for testing
    class MockElement implements IElement {
        private final Long value;

        MockElement(Long value) {
            this.value = value;
        }

        @Override
        public Long getSum() {
            return value;
        }
    }

    @Test
    void testAddElementsAndSum() {
        Portfolio portfolio = new Portfolio();
        portfolio.add(new MockElement(10L));
        portfolio.add(new MockElement(20L));
        portfolio.add(new MockElement(30L));
        assertEquals(60L, portfolio.getSum());
    }

    @Test
    void testEmptyPortfolio() {
        Portfolio portfolio = new Portfolio();
        assertEquals(0L, portfolio.getSum());
    }

    @Test
    void testSingleElement() {
        Portfolio portfolio = new Portfolio();
        portfolio.add(new MockElement(1000L));
        assertEquals(100L, portfolio.getSum());
    }

    @Test
    void testNullElement() {
        Portfolio portfolio = new Portfolio();
        portfolio.add(null);
        assertThrows(NullPointerException.class, portfolio::getSum);
    }

    @Test
    void testNonIElementObject() {
        // This test is not applicable since the method signature ensures only IElement objects can be added
    }
}
