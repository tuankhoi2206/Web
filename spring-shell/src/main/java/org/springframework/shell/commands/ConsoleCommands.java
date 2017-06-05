/*
 * Copyright 2011-2012 the original author or authors.
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
package org.springframework.shell.commands;

import static org.fusesource.jansi.Ansi.ansi;

import org.fusesource.jansi.AnsiConsole;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.stereotype.Component;

/**
 * Commands related to the manipulation of the jline console.
 * 
 * @author Mark Pollack
 * 
 */
@Component
public class ConsoleCommands implements CommandMarker {

	@CliCommand(value = { "cls", "clear" }, help = "Clears the console")
	public void clear() {
		AnsiConsole.out().print(ansi().eraseScreen().cursor(0, 0));
	}

}
