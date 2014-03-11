<div class="parts_layout" id="main-content" role="main">
	<div class="portlet-layout">
		<div class="aui-w-25 portlet-column portlet-column-first" id="webContentLayout">
			$processor.processPortlet("portlet_parts_WAR_PartsInventoryportlet");
			$processor.processColumn("column-1", "portlet-column-content portlet-column-content-first")
		</div>
		<div class="aui-w50 portlet-column portlet-column-last" id="column-2">
			$processor.processColumn("column-2", "portlet-column-content portlet-column-content-last")
		</div>
		<div class="aui-w25 portlet-column portlet-column-last" id="column-3">
			$processor.processPortlet("3");
			$processor.processColumn("column-3", "portlet-column-content portlet-column-content-last")
		</div>
	</div>
</div>
