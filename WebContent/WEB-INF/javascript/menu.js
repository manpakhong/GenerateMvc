  $(document).ready(function () {
        try
        {
            switch (theme) {
                case 'shinyblack':
                    $($.find('.megamenu-ul li a:link')).css('color', '#fff');
                    $($.find('.megamenu-ul li a:hover')).css('color', '#fff');
                    $($.find('.megamenu-ul li a:visited')).css('color', '#fff');
                    $($.find('.jqx-menuitem-header')).css('color', '#fff');
                    break;
                default:
                    $($.find('.megamenu-ul li a:link')).css('color', '#2d628a');
                    $($.find('.megamenu-ul li a:hover')).css('color', '#2d628a');
                    $($.find('.megamenu-ul li a:visited')).css('color', '#2d628a');
                    $($.find('.jqx-menuitem-header')).css('color', '#2d628a');
                    break;
            }
        }
        catch (error) {
        }
        // Create a jqxMenu
        $("#jqxMenu").jqxMenu({ width:1300, height: '30px', autoOpen: true, autoCloseOnMouseLeave: false, showTopLevelArrows: true});
        $("#jqxMenu").css('visibility', 'visible');
//        $(".buyonline").jqxLinkButton({ width: 150, height: 25});
//        $(".jqx-menu-search").jqxButton({ width: 60, height: 18});
    });