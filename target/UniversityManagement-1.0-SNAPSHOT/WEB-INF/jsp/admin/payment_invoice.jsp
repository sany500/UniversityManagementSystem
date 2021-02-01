<%-- 
    Document   : payment_invoice
    Created on : Jan 23, 2021, 1:13:30 AM
    Author     : sany5
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<jsp:include page="/WEB-INF/jsp/common/header.jsp" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <div class="row" style="margin-bottom: 0px;margin-top: 10px;">
        <div class="col">
            <p class="text-center" style="margin-bottom: 0px;font-size: 24px;"><strong>East-West University</strong></p>
            <p class="text-center" style="margin-bottom: 0px;">Office of Students Accounts, Semester Bill</p>
        </div>
    </div>
    <div class="row" style="font-size: 16px;margin-top: 10px;">
        <div class="col"></div>
        <div class="col">
            <p class="text-right" style="margin-bottom: 0px;font-size: 12px;">Pay online through</p>
            <p class="text-right" style="margin-bottom: 0px;font-size: 12px;">https://east-west.edu.bd</p>
            <p class="text-right" style="margin-bottom: 0px;">Or</p>
        </div>
    </div>
    <div class="row" style="margin-top: 10px;">
        <div class="col">
            <p class="text-left" style="margin-bottom: 0px;font-size: 12px;"><strong>Jahurul Islam City Gate,</strong></p>
            <p class="text-left" style="margin-bottom: 0px;font-size: 12px;"><strong>A/2 Jahurul Islam Ave,</strong></p>
            <p class="text-left" style="margin-bottom: 0px;font-size: 12px;"><strong>Dhaka 1212</strong></p>
        </div>
        <div class="col">
            <p class="text-right" style="margin-bottom: 0px;font-size: 12px;"><strong>Mail Payments to</strong></p>
            <p class="text-right" style="margin-bottom: 0px;font-size: 12px;">East-west University</p>
            <p class="text-right" style="margin-bottom: 0px;font-size: 12px;">P,O Box 880412</p>
            <p class="text-right" style="margin-bottom: 0px;font-size: 12px;">A/2 Jahurul Islam Ave,Dhaka 1212</p>
        </div>
    </div>
    <div class="row" style="margin-top: 10px;">
        <div class="col"></div>
        <div class="col">

        </div>
    </div>
    <!-- <div class="row" style="margin-bottom: 0px;margin-top: 10px;">
        <div class="col">
            <p class="text-center" style="margin-bottom: 0px;font-size: 12px;">Paragraph</p>
            <p class="text-center" style="margin-bottom: 0px;font-size: 12px;">Paragraph</p>
        </div>
    </div> -->
    <div class="row" style="margin-bottom: 0px;margin-top: 10px;">
        <div class="col">
            <div class="table-responsive border rounded-0" style="font-size: 12px;">
                <table class="table">
                    <thead>
                        <tr>
                            <th class="border rounded-0 border-white" style="background-color: #ff0000; color: white;">Student Name</th>
                            <th class="text-right border rounded-0 border-white" style="background-color: #ff0000; color: white;">Bill Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td style="padding: 10px;">${map.p.studentName}</td>
                            <td class="text-right" style="padding: 10px;">${map.p.paymentDate}</td>
                        </tr>
                        <tr></tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="row" style="margin-bottom: 0px;margin-top: 10px;">
        <div class="col">
            <div class="table-responsive border rounded-0" style="font-size: 12px;">
                <table class="table">
                    <thead>
                        <tr>
                            <th class="border rounded-0 border-white" style="background-color: #ff0000;width: 900px; color: white;">Payment Transaction Id</th>
                            <th class="text-right border rounded-0 border-white" style="background-color: #ff0000; color: white;">Payment Method</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td style="padding: 10px;">${map.p.trId}</td>
                            <td class="text-right" style="padding: 10px;">${map.p.paymentMethod}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="row" style="margin-bottom: 0px;margin-top: 10px;">
        <div class="col">
            <div class="table-responsive border rounded-0" style="font-size: 12px;">
                <table class="table">
                    <thead>
                        <tr>
                            <th class="border rounded-0 border-white" style="background-color: #ff0000;width: 300px; color: white;">Activity Description</th>
                            <th class="border rounded-0 border-white" style="background-color: #ff0000;width: 280px; color: white;">Charges/Refunds</th>
                            <th class="border rounded-0 border-white" style="background-color: #ff0000;width: 300px; color: white;">Credits</th>
                            <th class="text-right border rounded-0 border-white" style="background-color: #ff0000;width: 207px; color: white;">Amount</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td style="padding: 10px;">Tution Fee</td>
                            <td class="text-right" style="padding: 10px;">${map.p.tutionFee}</td>
                            <td class="text-right" style="padding: 10px;"></td>
                            <td class="text-right" style="padding: 10px;">${map.p.tutionFee}</td>
                        </tr>
                        <tr>
                            <td style="padding: 10px;">Special Fee</td>
                            <td class="text-right" style="padding: 10px;">${map.p.specialFee}</td>
                            <td class="text-right" style="padding: 10px;"></td>
                            <td class="text-right" style="padding: 10px;">${map.p.specialFee}</td>
                        </tr>
                        <tr>
                            <td style="padding: 10px;">Facilities Service</td>
                            <td class="text-right" style="padding: 10px;">${map.p.facilitiesFee}</td>
                            <td class="text-right" style="padding: 10px;"></td>
                            <td class="text-right" style="padding: 10px;">${map.p.facilitiesFee}</td>
                        </tr>
                        <tr>
                            <td style="padding: 10px;">Student Id Fee</td>
                            <td class="text-right" style="padding: 10px;">${map.p.studentIdFee}</td>
                            <td class="text-right" style="padding: 10px;"></td>
                            <td class="text-right" style="padding: 10px;">${map.p.studentIdFee}</td>
                        </tr>
                        <tr>
                            <td style="padding: 10px;">Library Fee</td>
                            <td class="text-right" style="padding: 10px;">${map.p.libraryFee}</td>
                            <td class="text-right" style="padding: 10px;"></td>
                            <td class="text-right" style="padding: 10px;">${map.p.libraryFee}</td>
                        </tr>
                        <tr>
                            <td style="padding: 10px;">Technology Fee</td>
                            <td class="text-right" style="padding: 10px;">${map.p.technologyFee}</td>
                            <td class="text-right" style="padding: 10px;"></td>
                            <td class="text-right" style="padding: 10px;">${map.p.technologyFee}</td>
                        </tr>
                        <tr>
                            <td style="padding: 10px;">Registration Fee</td>
                            <td class="text-right" style="padding: 10px;">${map.p.registrationFee}</td>
                            <td class="text-right" style="padding: 10px;"></td>
                            <td class="text-right" style="padding: 10px;">${map.p.registrationFee}</td>
                        </tr>
                        <tr>
                            <td style="padding: 10px;">Housing Fee</td>
                            <td class="text-right" style="padding: 10px;">${map.p.housingFee}</td>
                            <td class="text-right" style="padding: 10px;"></td>
                            <td class="text-right" style="padding: 10px;">${map.p.housingFee}</td>
                        </tr>
                        <tr>
                            <td style="padding: 10px;">Financial Aid</td>
                            <td class="text-right" style="padding: 10px;">${map.p.financialAid}</td>
                            <td class="text-right" style="padding: 10px;">0.00</td>
                            <td class="text-right" style="padding: 10px;">${map.p.financialAid}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="row" style="margin-bottom: 0px;margin-top: 10px;">
        <div class="col">
            <div class="table-responsive border rounded-0" style="font-size: 12px;">
                <table class="table">
                    <thead>
                        <tr>
                            <th class="border rounded-0 border-white" style="background-color: #ff0000;width: 150px; color: white;">Prior Invoice Balance</th>
                            <th class="border rounded-0 border-white" style="background-color: #ff0000;width: 150px; color: white;">-Payments</th>
                            <th class="border rounded-0 border-white" style="background-color: #ff0000;width: 280px; color: white;">+Charges Refund</th>
                            <th class="border rounded-0 border-white" style="background-color: #ff0000;width: 300px; color: white;">Credits</th>
                            <th class="text-right border rounded-0 border-white" style="background-color: #ff0000;width: 207px; color: white;">=Total Amount</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td style="padding: 10px;"></td>
                            <td class="text-right" style="padding: 10px;">0.00</td>
                            <td class="text-right" style="padding: 10px;">0.00</td>
                            <td class="text-right" style="padding: 10px;">0.00</td>
                            <td class="text-right" style="padding: 10px;">=${map.p.totalFee}/-</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="row" style="margin-bottom: 0px;margin-top: 0px;">
        <div class="col">
            <p class="text-left" style="margin-bottom: 0px;font-size: 12px;padding: 10px;">Late Payment Warning</p>
            
        </div>

    </div>
</div>
<div class="d-flex justify-content-center"><button class="btn btn-info" onclick="print()">Print</button></div>

<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script>
    print(){
        window.print();
    };
</script>
<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />