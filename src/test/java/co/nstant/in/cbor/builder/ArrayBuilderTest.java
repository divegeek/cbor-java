package co.nstant.in.cbor.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import co.nstant.in.cbor.CborBuilder;
import co.nstant.in.cbor.model.Array;
import co.nstant.in.cbor.model.ByteString;
import co.nstant.in.cbor.model.DataItem;
import co.nstant.in.cbor.model.DoublePrecisionFloat;
import co.nstant.in.cbor.model.SimpleValue;
import co.nstant.in.cbor.model.SinglePrecisionFloat;

public class ArrayBuilderTest {

    @Test
    public void shouldAddBoolean() {
        CborBuilder builder = new CborBuilder();
        List<DataItem> dataItems = builder.addArray()
            .add(true)
            .end()
            .build();
        assertEquals(1, dataItems.size());
        assertTrue(dataItems.get(0) instanceof Array);
        Array array = (Array) dataItems.get(0);
        assertEquals(1, array.getDataItems().size());
        assertTrue(array.getDataItems().get(0) instanceof SimpleValue);
    }

    @Test
    public void shouldAddFloat() {
        CborBuilder builder = new CborBuilder();
        List<DataItem> dataItems = builder.addArray()
            .add(1.0f)
            .end()
            .build();
        assertEquals(1, dataItems.size());
        assertTrue(dataItems.get(0) instanceof Array);
        Array array = (Array) dataItems.get(0);
        assertEquals(1, array.getDataItems().size());
        assertTrue(array.getDataItems().get(0) instanceof SinglePrecisionFloat);
    }

    @Test
    public void shouldAddDouble() {
        CborBuilder builder = new CborBuilder();
        List<DataItem> dataItems = builder.addArray()
            .add(1.0d)
            .end()
            .build();
        assertEquals(1, dataItems.size());
        assertTrue(dataItems.get(0) instanceof Array);
        Array array = (Array) dataItems.get(0);
        assertEquals(1, array.getDataItems().size());
        assertTrue(array.getDataItems().get(0) instanceof DoublePrecisionFloat);
    }

    @Test
    public void shouldAddByteArray() {
        CborBuilder builder = new CborBuilder();
        List<DataItem> dataItems = builder.addArray()
            .add(new byte[] { 0x0 })
            .end()
            .build();
        assertEquals(1, dataItems.size());
        assertTrue(dataItems.get(0) instanceof Array);
        Array array = (Array) dataItems.get(0);
        assertEquals(1, array.getDataItems().size());
        assertTrue(array.getDataItems().get(0) instanceof ByteString);
    }

}