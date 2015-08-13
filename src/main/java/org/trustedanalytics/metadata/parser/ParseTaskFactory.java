/**
 * Copyright (c) 2015 Intel Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.trustedanalytics.metadata.parser;

import org.trustedanalytics.metadata.datacatalog.DataCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

import org.trustedanalytics.metadata.parser.api.MetadataParseRequest;
import org.trustedanalytics.store.ObjectStore;

@Service
public class ParseTaskFactory {

    private final ObjectStore objectStore;
    private final ParserService parserService;
    
    @Autowired
    public ParseTaskFactory(ObjectStore objectStore, ParserService parserService) {
        this.objectStore = objectStore;
        this.parserService = parserService;
    }

    public MetadataParseTask newParseTask(MetadataParseRequest desc, DataCatalog dataCatalog, RestOperations restOperations) {
        return new MetadataParseTask(objectStore, dataCatalog, desc, restOperations, parserService);
    }
    
}
