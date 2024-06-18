// const { name, phone, email } = req.body;
// const pdfFilePath = req.file.path;
//
// const transporter = nodemailer.createTransport({
//     service: 'gmail',
//     auth: {
//         user: 'your-email@gmail.com', // Địa chỉ email của bạn
//         pass: 'your-password' // Mật khẩu email của bạn
//     }
// });
//
// const mailOptions = {
//     from: 'letientung104@gmail.com',
//     to: email,
//     subject: 'Hóa đơn đặt tour',
//     text: 'Xin chào,\n\nĐây là hóa đơn đặt tour của bạn.\n\nCảm ơn bạn đã sử dụng dịch vụ của chúng tôi!',
//     attachments: [
//         {
//             filename: 'BillDatTour.pdf',
//             path: pdfFilePath
//         }
//     ]
// };
//
// transporter.sendMail(mailOptions, (error, info) => {
//     if (error) {
//         console.error('Error sending email:', error);
//         res.status(500).send('Lỗi gửi email');
//     } else {
//         console.log('Email sent: ' + info.response);
//         res.status(200).send('Email đã được gửi thành công');
//     }
// });
