/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control.admin;

import dal.DashboardDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.List;
import model.Order;
import model.OrderDetail;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author asus
 */
@WebServlet(name = "Export", urlPatterns = {"/export"})
public class Export extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Export</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Export at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String year_raw = request.getParameter("year");
        int year;
        if (year_raw != null) {
            year = Integer.parseInt(year_raw);
        } else {
            year = 2023;
        }

        // Khởi tạo workbook và sheet
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Năm " + year);
        XSSFSheet sheet2 = workbook.createSheet("Số sản phẩm bán được năm " + year);
        XSSFSheet sheet3 = workbook.createSheet("Lãi từng tháng năm " + year);

        CellStyle centerBorderStyle = workbook.createCellStyle();
        centerBorderStyle.setAlignment(HorizontalAlignment.CENTER);
        centerBorderStyle.setBorderTop(BorderStyle.THIN);
        centerBorderStyle.setBorderBottom(BorderStyle.THIN);
        centerBorderStyle.setBorderLeft(BorderStyle.THIN);
        centerBorderStyle.setBorderRight(BorderStyle.THIN);

        DashboardDAO dd = new DashboardDAO();
        // Tạo tiêu đề cho sheet
        String[] headers = {"Mã đơn hàng", "Ngày đặt hàng", "Khách hàng", "Tên sản phẩm", "Dung tích", "Số lượng", "Tổng tiền"};
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);

            sheet.autoSizeColumn(i);

        }

        // Tạo tiêu đề cho sheet2
        String[] headers2 = {"Mã sản phẩm", "Tên sản phẩm", "Dung tích", "Tổng số sản phẩm đã bán ra"};
        Row headerRow2 = sheet2.createRow(0);
        for (int i = 0; i < headers2.length; i++) {
            Cell cell = headerRow2.createCell(i);
            cell.setCellValue(headers2[i]);
            sheet2.autoSizeColumn(i);
        }
        // Tạo tiêu đề cho sheet3
        String[] headers3 = {"Tháng", "Giá nhập vào", "Giá bán ra", "Tiền lãi"};
        Row headerRow3 = sheet3.createRow(0);
        for (int i = 0; i < headers3.length; i++) {
            Cell cell = headerRow3.createCell(i);
            cell.setCellValue(headers3[i]);
            sheet3.autoSizeColumn(i);
        }

// Lấy dữ liệu từ database
        List<OrderDetail> listOrder = dd.getOrderDoneExcel(year);
        List<OrderDetail> listProduct = dd.getProductSoldExcel(year);
        List<OrderDetail> listProfit = dd.getProfitEachMonth(year);

        // sheet1
        int rowNum = 1;
        if (listOrder.size() == 0) {
            XSSFRow row = sheet.createRow(1);
            XSSFCell cell = row.createCell(1);
            cell.setCellValue("Chưa có đơn hàng nào!");
        } else {
            for (OrderDetail order : listOrder) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(order.getOrder().getOrder_date());
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(order.getOrder().getId());
                row.createCell(1).setCellValue(calendar.get(Calendar.DAY_OF_MONTH) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.YEAR));
                row.createCell(2).setCellValue(order.getOrder().getFirstname() + " " + order.getOrder().getLastname());
                row.createCell(3).setCellValue(order.getProduct().getTitle());
                row.createCell(4).setCellValue(order.getSize().getName());
                row.createCell(5).setCellValue(order.getNum());
                row.createCell(6).setCellValue(order.getTotal_money_out());
            }
            // Kẻ border cho toàn bộ bảng
            int lastRowNum = sheet.getLastRowNum();
            for (int i = 0; i <= lastRowNum; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < 7; j++) {
                    Cell cell = row.getCell(j);
                    cell.setCellStyle(centerBorderStyle);
                }
            }
        }

        //sheet2
        int rowNum2 = 1;
        if (listProduct.size() == 0) {
            XSSFRow row = sheet2.createRow(1);
            XSSFCell cell = row.createCell(1);
            cell.setCellValue("Không có sản phẩm nào được bán ra!");
        } else {
            for (OrderDetail order : listProduct) {

                Row row = sheet2.createRow(rowNum2++);
                row.createCell(0).setCellValue(order.getProduct().getId());
                row.createCell(1).setCellValue(order.getProduct().getTitle());
                row.createCell(2).setCellValue(order.getSize().getName());
                row.createCell(3).setCellValue(order.getNum());

            }
            // Kẻ border cho toàn bộ bảng
            int lastRowNum2 = sheet2.getLastRowNum();
            for (int i = 0; i <= lastRowNum2; i++) {
                Row row = sheet2.getRow(i);
                for (int j = 0; j < 4; j++) {
                    Cell cell = row.getCell(j);
                    cell.setCellStyle(centerBorderStyle);
                }
            }
        }

        // sheet3
        int rowNum3 = 1;
        double sum = 0;
        double sum_in = 0;
        double sum_out = 0;
        if (listProfit.size() == 0) {
            XSSFRow row = sheet3.createRow(1);
            XSSFCell cell = row.createCell(1);
            cell.setCellValue("Chưa thu được lợi nhuận nào!");
        } else {
            for (OrderDetail order : listProfit) {

                Row row = sheet3.createRow(rowNum3++);
                row.createCell(0).setCellValue((order.getOrder().getOrder_date().getMonth() + 1));
                row.createCell(1).setCellValue(order.getTotal_money_in());
                row.createCell(2).setCellValue(order.getTotal_money_out());
                row.createCell(3).setCellValue(order.getPrice());
                sum += order.getPrice();
                sum_in+= order.getTotal_money_in();
                sum_out+= order.getTotal_money_out();
            }
            Row totalRow = sheet3.createRow(rowNum3);
            totalRow.createCell(0).setCellValue("Tổng");
            totalRow.createCell(1).setCellValue(sum_in);
            totalRow.createCell(2).setCellValue(sum_out);
            totalRow.createCell(3).setCellValue(sum);
            // Kẻ border cho toàn bộ bảng
            int lastRowNum3 = sheet3.getLastRowNum();
            for (int i = 0; i <= lastRowNum3; i++) {
                Row row = sheet3.getRow(i);
                for (int j = 0; j < 4; j++) {
                    Cell cell = row.getCell(j);
                    cell.setCellStyle(centerBorderStyle);
                }
            }
        }

        // Thiết lập tiêu đề và định dạng file Excel
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename= Statistic Detail in " + year + ".xlsx");

        // Ghi dữ liệu của file Excel vào output stream
        workbook.write(response.getOutputStream());
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
