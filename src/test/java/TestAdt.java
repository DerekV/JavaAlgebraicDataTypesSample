import junit.framework.TestCase;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.fail;

public class TestAdt {

    private JustWalks walker = null;

    private PassengerCar car;

    private ModeOfTransportContainer MOT1 = new ModeOfTransportContainer() {
        @Override
        public TransportModeADT getModeOfTransport() {
            return JustWalks.BOOTS;
        }
    };

    private ModeOfTransportContainer MOT2 = new ModeOfTransportContainer() {
        @Override
        public TransportModeADT getModeOfTransport() {
            return new PassengerCar("VOLT",Brand.CHEVY,5);
        }
    };
    private ModeOfTransportContainer MOT3 = new ModeOfTransportContainer() {
        @Override
        public TransportModeADT getModeOfTransport() {
            return new Truck("Escalade",Brand.CADILLAC,1700);
        }
    };
    @Test
    public void testAdt1() {
        TransportModeADT subject = MOT1.getModeOfTransport();



        subject.acceptMatcher(new TransportModeADT.Matcher() {
            @Override
            public void match(@NotNull PassengerCar e) {
                fail("I got a car!");
            }

            @Override
            public void match(@NotNull Truck v) {
                fail("I got a truck!");
            }

            @Override
            public void match(@NotNull JustWalks o) {
                walker = o;
            }
        });

        assertNotNull(walker);
        assertEquals(walker,JustWalks.BOOTS);
    }

    @Test
    public void testAdt2() {
        TransportModeADT subject = MOT2.getModeOfTransport();



        subject.acceptMatcher(new TransportModeADT.Matcher() {
            @Override
            public void match(@NotNull PassengerCar e) {
                car = e;
            }

            @Override
            public void match(@NotNull Truck v) {
                fail("I got a truck!");
            }

            @Override
            public void match(@NotNull JustWalks o) {
                fail("I got a walker!");
            }
        });

        assertNotNull(car);
        assertEquals(car.getName(),"VOLT");
        assertEquals(car.getBrand(),Brand.CHEVY);
        assertEquals(car.getCapacity(),5);
    }

 @Test
    public void testAdtUsingMockito() {
        TransportModeADT subject = MOT3.getModeOfTransport();

     TransportModeADT.Matcher mockMatcher = Mockito.mock(TransportModeADT.Matcher.class);
     subject.acceptMatcher(mockMatcher);
     ArgumentCaptor<Truck> truckCaptor = ArgumentCaptor.forClass(Truck.class);
     Mockito.verify(mockMatcher).match(truckCaptor.capture());
     Mockito.verifyNoMoreInteractions(mockMatcher);
     TestCase.assertEquals(truckCaptor.getValue().getBrand(), Brand.CADILLAC);
     TestCase.assertEquals(truckCaptor.getValue().getName(), "Escalade");
     TestCase.assertEquals(truckCaptor.getValue().getTowCapacity(),1700);
    }


}
