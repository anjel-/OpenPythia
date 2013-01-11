package org.openpythia.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class SSUtilities {

    public static Row copyRow(Sheet sheet, Row sourceRow,
            int destination) {
        Row newRow = sheet.createRow(destination);
        // get the last row from the headings
        int lastCol = sheet.getRow(0).getLastCellNum();
        for (int currentCol = 0; currentCol <= lastCol; currentCol++) {
            Cell newCell = newRow.createCell(currentCol);

            // if there is a cell in the template, copy its content and style
            Cell currentCell = sourceRow.getCell(currentCol);
            if (currentCell != null) {
                newCell.setCellStyle(currentCell.getCellStyle());
                newCell.setCellComment(currentCell.getCellComment());
                switch (currentCell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        newCell.setCellValue(currentCell.getStringCellValue());
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        newCell.setCellValue(currentCell.getNumericCellValue());
                        break;
                    case Cell.CELL_TYPE_FORMULA:
                        String dummy = currentCell.getCellFormula();
                        dummy = dummy.replace("Row",
                                String.valueOf(destination + 1));
                        newCell.setCellFormula(dummy);
                        newCell.setCellFormula(currentCell.getCellFormula()
                                .replace("Row",
                                        String.valueOf(destination + 1)));
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        newCell.setCellValue(currentCell.getBooleanCellValue());
                        break;
                    default:
                }
            }
        }
        return newRow;
    }

}