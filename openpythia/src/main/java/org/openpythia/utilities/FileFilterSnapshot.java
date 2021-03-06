/**
 * Copyright 2012 msg systems ag
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/
package org.openpythia.utilities;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class FileFilterSnapshot extends FileFilter {

	@Override
	public boolean accept(File file) {
		if (file.isDirectory()) {
			return true;
		}

		String extension = FileSelectorUtility.getExtension(file);
		if (extension != null) {
			if (extension.equals("snap")) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String getDescription() {
		return "Snapshot  Files (.snap)";
	}

}
