/*
 *  This file is part of JEngine.
 *  *
 *  * Copyright (C) 2013-2014 Cetus (http://cs1.com.ua/). All rights reserved.
 *  *
 *  * JEngine is free software: you can redistribute it and/or modify
 *  * it under the terms of the GNU General Public License as published by
 *  * the Free Software Foundation, either version 3 of the License, or
 *  * (at your option) any later version.
 *  *
 *  * JEngine is distributed in the hope that it will be useful,
 *  * but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  * GNU General Public License for more details.
 *  *
 *  * You should have received a copy of the GNU General Public License
 *  * along with JEngine.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jengine.utils.commons;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class Variant<T> {
    private T value = null;

    public Variant(T value) {
        this.value = value;
    }

    public Object convertTo(Class cls) {
        if (value == null) {
            return null;
        } else if (value.getClass().equals(Character.class)) {
            return convertCharacterTo(cls);
        } else if (value.getClass().equals(String.class)) {
            return convertStringTo(cls);
        } else if (value.getClass().equals(Byte.class)) {
            return convertByteTo(cls);
        } else if (value.getClass().equals(Short.class)) {
            return convertShortTo(cls);
        } else if (value.getClass().equals(Long.class)) {
            return convertLongTo(cls);
        } else if (value.getClass().equals(Integer.class)) {
            return convertIntegerTo(cls);
        } else if (value.getClass().equals(Float.class)) {
            return convertFloatTo(cls);
        } else if (value.getClass().equals(Double.class)) {
            return convertDoubleTo(cls);
        } else if (value.getClass().equals(Date.class)) {
            return convertDateTo(cls);
        } else if (value.getClass().equals(Boolean.class)) {
            return convertBooleanTo(cls);
        } else if (value.getClass().equals(BigDecimal.class)) {
            return convertBigDecimalTo(cls);
        } else if (value.getClass().equals(BigInteger.class)) {
            return convertBigIntegerTo(cls);
        } else if (value.getClass().equals(byte[].class)) {
            return convertByteArrayTo(cls);
        }

        return value;
    }

    public Object convertCharacterTo(Class cls) {
        if (cls.equals(Integer.class)) {
            return Character.getNumericValue((Character) value);
        } else if (cls.equals(Long.class)) {
            return new Integer(Character.getNumericValue((Character) value)).longValue();
        } else if (cls.equals(String.class)) {
            return String.valueOf(value);
        } else if (cls.isArray() && cls.getComponentType().equals(Byte.class)) {
            return String.valueOf(value).getBytes();
        }

        return value;
    }

    public Object convertStringTo(Class cls) {
        if (cls.equals(Integer.class)) {
            return Integer.parseInt((String) value);
        } else if (cls.equals(Long.class)) {
            return Long.parseLong((String) value);
        } else if (cls.equals(Float.class)) {
            return Float.valueOf((String) value);
        } else if (cls.equals(Double.class)) {
            return Double.valueOf((String) value);
        } else if (cls.isArray() && cls.getComponentType().equals(Byte.class)) {
            return ((String)value).getBytes();
        }

        return value;
    }

    public Object convertByteArrayTo(Class cls) {
        if (cls.equals(Integer.class)) {
            return new BigInteger((byte[]) value).intValue();
        } else if (cls.equals(Long.class)) {
            return new BigInteger((byte[]) value).longValue();
        } else if (cls.equals(Float.class)) {
            return new BigInteger((byte[]) value).floatValue();
        } else if (cls.equals(Double.class)) {
            return new BigInteger((byte[]) value).doubleValue();
        } else if (cls.equals(String.class)) {
            return new String((byte[]) value);
        }

        return value;
    }

    public Object convertByteTo(Class cls) {
        if (cls.equals(Integer.class)) {
            return ((Byte)value).intValue();
        } if (cls.equals(Long.class)) {
            return ((Byte)value).longValue();
        } if (cls.equals(Float.class)) {
            return ((Byte)value).floatValue();
        } if (cls.equals(Double.class)) {
            return ((Byte)value).doubleValue();
        } else if (cls.equals(String.class)) {
            return String.valueOf(value);
        } else if (cls.equals(Boolean.class)) {
            return ((Byte) value) != 0;
        }


        return value;
    }

    public Object convertShortTo(Class cls) {
        if (cls.equals(Integer.class)) {
            return ((Short)value).intValue();
        } else if (cls.equals(Long.class)) {
            return ((Short)value).longValue();
        } else if (cls.equals(Float.class)) {
            return ((Short)value).floatValue();
        } else if (cls.equals(Double.class)) {
            return ((Short)value).doubleValue();
        } else if (cls.equals(String.class)) {
            return String.valueOf(value);
        } else if (cls.equals(Byte.class)) {
            return ((Short) value).byteValue();
        } else if (cls.isArray() && cls.getComponentType().equals(Byte.class)) {
            return toByteArray((Short) value);
        }

        return value;
    }

    public Object convertLongTo(Class cls) {
        if (cls.equals(Integer.class)) {
            return ((Long)value).intValue();
        } else if (cls.equals(Short.class)) {
            return ((Long)value).shortValue();
        } else if (cls.equals(Float.class)) {
            return ((Long)value).floatValue();
        } else if (cls.equals(Double.class)) {
            return ((Long)value).doubleValue();
        } else if (cls.equals(String.class)) {
            return String.valueOf(value);
        } else if (cls.isArray() && cls.getComponentType().equals(Byte.class)) {
            return toByteArray((Long) value);
        }

        return value;
    }

    public Object convertIntegerTo(Class cls) {
        if (cls.equals(Long.class)) {
            return ((Integer)value).longValue();
        } else if (cls.equals(Short.class)) {
            return ((Integer)value).shortValue();
        } else if (cls.equals(Float.class)) {
            return ((Integer)value).floatValue();
        } else if (cls.equals(Double.class)) {
            return ((Integer)value).doubleValue();
        } else if (cls.equals(String.class)) {
            return String.valueOf(value);
        } else if (cls.isArray() && cls.getComponentType().equals(Byte.class)) {
            return toByteArray((Integer) value);
        }

        return value;
    }

    public Object convertFloatTo(Class cls) {
        if (cls.equals(Integer.class)) {
            return ((Float)value).intValue();
        } else if (cls.equals(Long.class)) {
            return ((Float)value).longValue();
        } else if (cls.equals(Short.class)) {
            return ((Float)value).shortValue();
        } else if (cls.equals(Double.class)) {
            return ((Float)value).doubleValue();
        } else if (cls.equals(String.class)) {
            return String.valueOf(value);
        }

        return value;
    }

    public Object convertDoubleTo(Class cls) {
        if (cls.equals(Integer.class)) {
            return ((Double)value).intValue();
        } else if (cls.equals(Long.class)) {
            return ((Double)value).longValue();
        } else if (cls.equals(Short.class)) {
            return ((Double)value).shortValue();
        } else if (cls.equals(Float.class)) {
            return ((Double)value).floatValue();
        } else if (cls.equals(String.class)) {
            return String.valueOf(value);
        }

        return value;
    }

    public Object convertDateTo(Class cls) {
        if (cls.equals(Integer.class)) {
            return new Long(((Date)value).getTime()).intValue();
        } else if (cls.equals(Short.class)) {
            return new Long(((Date)value).getTime()).shortValue();
        } else if (cls.equals(String.class)) {
            return value.toString();
        }

        return value;
    }

    public Object convertBooleanTo(Class cls) {
        if (cls.equals(Integer.class)) {
            return ((Boolean) value) ? 1 : 0;
        } else if (cls.equals(Short.class)) {
            return ((Boolean) value) ? (short) 1 : (short) 0;
        } else if (cls.equals(Long.class)) {
            return ((Boolean) value) ? (long) 1 : (long) 0;
        } else if (cls.equals(String.class)) {
            return value.toString();
        }

        return value;
    }

    public Object convertBigDecimalTo(Class cls) {
        if (cls.equals(Integer.class)) {
            return ((BigDecimal) value).intValue();
        } else if (cls.equals(Short.class)) {
            return ((BigDecimal) value).shortValue();
        } else if (cls.equals(Long.class)) {
            return ((BigDecimal) value).longValue();
        } else if (cls.equals(Float.class)) {
            return ((BigDecimal) value).floatValue();
        } else if (cls.equals(Double.class)) {
            return ((BigDecimal) value).doubleValue();
        } else if (cls.equals(Byte.class)) {
            return ((BigDecimal) value).byteValue();
        } else if (cls.isArray() && cls.getComponentType().equals(Byte.class)) {
            return ((BigDecimal) value).unscaledValue().toByteArray();
        } else if (cls.equals(String.class)) {
            return value.toString();
        }

        return value;
    }

    public Object convertBigIntegerTo(Class cls) {
        if (cls.equals(Integer.class)) {
            return ((BigInteger) value).intValue();
        } else if (cls.equals(Short.class)) {
            return ((BigInteger) value).shortValue();
        } else if (cls.equals(Long.class)) {
            return ((BigInteger) value).longValue();
        } else if (cls.equals(Float.class)) {
            return ((BigInteger) value).floatValue();
        } else if (cls.equals(Double.class)) {
            return ((BigInteger) value).doubleValue();
        } else if (cls.equals(Byte.class)) {
            return ((BigInteger) value).byteValue();
        } else if (cls.isArray() && cls.getComponentType().equals(Byte.class)) {
            return ((BigInteger) value).toByteArray();
        } else if (cls.equals(String.class)) {
            return value.toString();
        }

        return value;
    }

    public static byte[] toByteArray(Number data) {
        Class<? extends Number> dataType = data.getClass();
        int length;
        long value;
        if (Byte.class == dataType) {
            length = Byte.SIZE / Byte.SIZE;
            value = (Byte) data;
        } else if (Short.class == dataType) {
            length = Short.SIZE / Byte.SIZE;
            value = (Short) data;
        } else if (Integer.class == dataType) {
            length = Integer.SIZE / Byte.SIZE;
            value = (Integer) data;
        } else if (Long.class == dataType) {
            length = Long.SIZE / Byte.SIZE;
            value = (Long) data;
        } else
            throw new IllegalArgumentException("Parameter must be one of the following types:\n Byte, Short, Integer, Long");
        byte[] byteArray = new byte[length];
        for (int i = 0; i < length; i++) {
            byteArray[i] = (byte) ((value >> (8 * (length - i - 1))) & 0xff);
        }
        return byteArray;
    }


}
