/*
 * Copyright (c) 2022, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.ballerina.stdlib.graphql.compiler;

import io.ballerina.compiler.syntax.tree.SyntaxKind;
import io.ballerina.projects.plugins.CodeGenerator;
import io.ballerina.projects.plugins.CodeGeneratorContext;
import io.ballerina.stdlib.graphql.compiler.service.validator.ListenerValidator;

import java.util.Arrays;

/**
 * Analyzes a Ballerina GraphQL service and report diagnostics, and generates a schema for a valid service.
 */
public class GraphqlCodeGenerator extends CodeGenerator {

    @Override
    public void init(CodeGeneratorContext generatorContext) {
        generatorContext.addSyntaxNodeAnalysisTask(new ServiceAnalysisTask(), SyntaxKind.SERVICE_DECLARATION);
        generatorContext.addSyntaxNodeAnalysisTask(new ListenerValidator(),
                                                   Arrays.asList(SyntaxKind.IMPLICIT_NEW_EXPRESSION,
                                                                 SyntaxKind.EXPLICIT_NEW_EXPRESSION));
    }
}
