/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.shvid.cassandra.core;

import org.springdata.cassandra.core.CassandraOperations;
import org.springdata.cassandra.cql.core.RingMember;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shvid.cassandra.config.SpringCassandraApplicationConfig;

public class CassandraClient {
	static CassandraOperations ops;

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringCassandraApplicationConfig.class);
		ops = context.getBean("cassandraTemplate", CassandraOperations.class);
		for (RingMember member : ops.cqlOps().describeRing()) {
			System.out.println(member.toString());
		}
	}
}