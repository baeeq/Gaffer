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
package gaffer.operation.simple.spark;

import gaffer.data.elementdefinition.view.View;
import org.apache.spark.SparkContext;

public class GetRDDOfAllElementsOperation extends AbstractGetRDDOperation<Void> {

    public GetRDDOfAllElementsOperation() { }

    public GetRDDOfAllElementsOperation(final SparkContext sparkContext) {
        setSparkContext(sparkContext);
    }

    public static class Builder extends AbstractGetRDDOperation.Builder<GetRDDOfAllElementsOperation, Void> {
        public Builder() {
            this(new GetRDDOfAllElementsOperation());
        }

        public Builder(final GetRDDOfAllElementsOperation op) {
            super(op);
        }

        public Builder sparkContext(final SparkContext sparkContext) {
            super.sparkContext(sparkContext);
            return this;
        }

        public Builder view(final View view) {
            super.view(view);
            return this;
        }

        @Override
        public GetRDDOfAllElementsOperation build() {
            return (GetRDDOfAllElementsOperation) super.build();
        }
    }
}