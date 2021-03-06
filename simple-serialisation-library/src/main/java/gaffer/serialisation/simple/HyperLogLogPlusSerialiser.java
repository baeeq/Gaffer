/*
 * Copyright 2016 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gaffer.serialisation.simple;

import com.clearspring.analytics.stream.cardinality.HyperLogLogPlus;
import gaffer.exception.SerialisationException;
import gaffer.serialisation.Serialisation;
import java.io.IOException;

public class HyperLogLogPlusSerialiser implements Serialisation {
    private static final long serialVersionUID = 2782098698280905174L;

    @Override
    public boolean canHandle(final Class clazz) {
        return HyperLogLogPlus.class.equals(clazz);
    }

    @Override
    public byte[] serialise(final Object object) throws SerialisationException {
        try {
            return ((HyperLogLogPlus) object).getBytes();
        } catch (IOException exception) {
            throw new RuntimeException("Failed to get bytes from HyperLogLogPlus sketch", exception);
        }
    }

    @Override
    public HyperLogLogPlus deserialise(final byte[] bytes) throws SerialisationException {
        try {
            return HyperLogLogPlus.Builder.build(bytes);
        } catch (IOException exception) {
            throw new RuntimeException("Failed to create HyperLogLogPlus sketch from given bytes", exception);
        }
    }

    @Override
    public boolean isByteOrderPreserved() {
        return false;
    }
}
