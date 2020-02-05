  $(document).ready(function () {
        try{
        	prepareLayout();
        }
        catch (error) {
        }
    });
  function prepareLayout(){
      // the 'layout' JSON array defines the internal structure of the layout
	  var layout = [{
	      type: 'layoutGroup',
		  orientation: 'vertical',
		  items: [{ // top
		      type: 'layoutGroup',
			  orientation: 'horizontal',
			  height: '50%',
			  items: [{ // west
				  type: "tabbedGroup",
				  width: '30%',
				  items: [{
	                  type: 'layoutPanel',
	                  title: 'Diagnosis',
	                  contentContainer: 'DiagnosisPanel'			  
				  },{
	                  type: 'layoutPanel',
	                  title: 'Alerts',
	                  contentContainer: 'AlertPanel'
				  },{
	                  type: 'layoutPanel',
	                  title: 'Allergens',
	                  contentContainer: 'AllergensPanel'
				  },{
	                  type: 'layoutPanel',
	                  title: 'Orders',
	                  contentContainer: 'OrderPanel'
				  },{
	                  type: 'layoutPanel',
	                  title: 'Triage',
	                  contentContainer: 'TriagePanel'
				  }]	  
			  },{ // middle
				  type: "documentGroup",
				  width: '40%',
				  items: [{
	                  type: 'documentPanel',
	                  title: 'Dr. Notes',
	                  contentContainer: 'DrNotePanel'			  
				  },{
	                  type: 'documentPanel',
	                  title: 'Letters',
	                  contentContainer: 'LetterPanel'
				  },{
	                  type: 'documentPanel',
	                  title: 'Sick Notes',
	                  contentContainer: 'SickNotePanel'
				  }]	
			  }, { // east
				  type: "tabbedGroup",
				  width: '30%',
				  items: [{
	                  type: 'layoutPanel',
	                  title: 'LAB',
	                  contentContainer: 'LabResultsPanel'			  
				  },{
	                  type: 'layoutPanel',
	                  title: 'XRay',
	                  contentContainer: 'XRayPanel'
				  },{
	                  type: 'layoutPanel',
	                  title: 'Endoscopy',
	                  contentContainer: 'EndoscopyResultsPanel'
				  },{
	                  type: 'layoutPanel',
	                  title: 'MRAS',
	                  contentContainer: 'MrasPanel'
				  }]	
			  }]
		  },{ // bottom
			  type: "tabbedGroup",
			  height: '50%',
			  items: [{
                  type: 'layoutPanel',
                  title: 'Observation Profile',
                  contentContainer: 'ObservationProfilePanel'			  
			  },{
                  type: 'layoutPanel',
                  title: 'Patient History',
                  contentContainer: 'PatientHistoryPanel'			  
			  }]
		  }]
	  }];

      $('#layoutDiv').jqxLayout({ width: 1300, height: 768, layout: layout });
  }